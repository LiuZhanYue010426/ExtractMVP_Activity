package com.example.disposable;

import io.reactivex.disposables.Disposable;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public interface RequestManager {
    void add(String tag, Disposable disposable);

    //移除订阅关系
    void remove(String tag);

    //取消订阅
    void cancle(String tag);

    //取消所有订阅
    void canclaAll();
}
