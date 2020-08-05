package com.example.callback;

import android.text.TextUtils;

import com.example.HttpGlobalConfig;
import com.example.disposable.RequestManagerIml;
import com.example.exceptiopn.ApiException;
import com.example.exceptiopn.ExceptionEngine;
import com.example.utils.ThreadUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseObserver implements Observer {
    String tag;
    @Override
    public void onSubscribe(Disposable d) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerIml.getInstance().add(tag, d);
        }
    }

    @Override
    public void onNext(Object o) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerIml.getInstance().remove(tag);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            ApiException apiException = (ApiException) e;
            onError(apiException.getMsg(),apiException.getCode());
        }else{
            onError("未知错误", ExceptionEngine.UN_KNOWN_ERROR);
        }
        if(!TextUtils.isEmpty(tag)){
            RequestManagerIml.getInstance().remove(tag);
        }
    }

    @Override
    public void onComplete() {
        if(!RequestManagerIml.getInstance().idDispose(tag)){
            RequestManagerIml.getInstance().cancle(tag);
        }
    }

    //回调错误信息
    protected abstract void onError(String msg, int code);

    public void canclend(){
        if(!ThreadUtils.isMainThread()){
            HttpGlobalConfig.getInstance().getHandler().post(new Runnable() {
                @Override
                public void run() {
                    cancle();
                }
            });
        }
    }

    protected abstract void cancle();

    public void setTag(String tag){
        this.tag = tag;
    }

}

