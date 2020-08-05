package com.example.mvplibrary.liuzhanyue.presenter;

import com.example.mvplibrary.liuzhanyue.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class BasePresenter<V extends BaseView> {
    public V mView;
    private WeakReference<V> weakReference;

    //绑定
    public void attachView(V v) {
        weakReference = new WeakReference<>(v);
        mView = weakReference.get();
    }

    //返回视图层对象
    public LifecycleProvider getLifeCycle() {
        return (LifecycleProvider) mView;
    }

    //解绑
    public void destoryView() {
        if (weakReference != null) {
            weakReference.clear();
        }
    }
}

