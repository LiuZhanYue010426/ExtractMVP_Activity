package com.example.client;

import com.example.callback.BaseObserver;
import com.example.exceptiopn.ExceptionEngine;
import com.google.gson.Gson;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * @date：2020/8/4
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class HttpObserable {
    LifecycleProvider lifecycleProvider;
    //绑定Activity具体的生命周期使用的
    ActivityEvent activityEvent;
    //板顶Fragment具体生命周期使用的
    FragmentEvent fragmentEvent;
    Observable observable;
    BaseObserver baseObserver;

    public HttpObserable(Buidler builder) {
        this.lifecycleProvider=builder.lifecycleProvider;
        this.activityEvent=builder.activityEvent;
        this.fragmentEvent=builder.fragmentEvent;
        this.observable=builder.observable;
        this.baseObserver=builder.baseObserver;
    }

    //对初始化返回值JsonElement进行转换操作
    public Observable map() {
        return observable.map(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return new Gson().toJson(o);
            }
        });
    }

    /*onErrorResumeNext*/
    //错误信息的分类回调
        private Observable onErrorResumeNext() {
        return bindlifecycle().onErrorResumeNext(new Function<Throwable, ObservableSource>() {
            @Override
            public ObservableSource apply(Throwable throwable) throws Exception {
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }

    private Observable doOnDispose() {
        if (baseObserver != null) {
            return onErrorResumeNext().doOnDispose(new Action() {
                @Override
                public void run() throws Exception {
                    baseObserver.canclend();
                }
            });
        }
        return onErrorResumeNext();
    }

    //Rxjava的生命周期进行绑定
    private Observable bindlifecycle() {
        Observable observable =map();
        if (lifecycleProvider != null) {
            if (activityEvent != null || fragmentEvent != null) {
                //两个同时存在,以 activity 为准
                if (activityEvent != null && fragmentEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
                }
                if (activityEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
                }
                if (fragmentEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(fragmentEvent));
                }
            } else {
                return map().compose(lifecycleProvider.bindToLifecycle());
            }
        }
        return observable;
    }

    //设置线程切换
    public Observable observable() {
        return doOnDispose().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public static Buidler createBuilder(Observable observable){
//        return new Buidler(observable);
//    }

    public static final class Buidler{
        LifecycleProvider lifecycleProvider;
        //绑定Activity具体的生命周的
        ActivityEvent activityEvent;
        //绑定Fragment的具体的生命周期的
        FragmentEvent fragmentEvent;
        Observable observable;
        BaseObserver baseObserver;

        public Buidler setLifecycleProvider(LifecycleProvider lifecycleProvider) {
            this.lifecycleProvider = lifecycleProvider;
            return this;
        }

        public Buidler setActivityEvent(ActivityEvent activityEvent) {
            this.activityEvent = activityEvent;
            return this;
        }

        public Buidler setFragmentEvent(FragmentEvent fragmentEvent) {
            this.fragmentEvent = fragmentEvent;
            return this;
        }

        public Buidler setBaseObserver(BaseObserver baseObserver) {
            this.baseObserver = baseObserver;
            return this;
        }

        public Buidler(Observable observable) {
            this.observable = observable;
        }

        public HttpObserable build(){
            return new HttpObserable(this);
        }
    }
}
