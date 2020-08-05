package com.example.disposable;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class RequestManagerIml implements RequestManager{
    private static volatile RequestManagerIml instance;
    //管理所有订阅关系的Map
    private static Map<String,Disposable> mMap = new HashMap<>();

    public RequestManagerIml() {
    }

    public static RequestManagerIml getInstance(){
        if(instance == null){
            synchronized (RequestManagerIml.class){
                if(instance==null){
                    instance = new RequestManagerIml();
                }
            }
        }
        return instance;
    }

    @Override
    public void add(String tag, Disposable disposable) {
        if(!TextUtils.isEmpty(tag)){
            mMap.put(tag, disposable);
        }
    }

    @Override
    public void remove(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            if(mMap!=null){
                return;
            }
            mMap.remove(tag);
        }
    }

    @Override
    public void cancle(String tag) {
        if(!TextUtils.isEmpty(tag)){
            if(mMap.get(tag)!=null){
                Disposable disposable = mMap.get(tag);
                if(!disposable.isDisposed()){
                    disposable.dispose();
                }
                mMap.remove(tag);
            }
        }
    }

    @Override
    public void canclaAll() {
        Disposable disposable = null;
        if(!mMap.isEmpty()){
            Set<String> keys = mMap.keySet();
            for (String key:
                 keys) {
                if(mMap.get(key)!=null){
                    disposable = mMap.get(key);
                }
                if(disposable!=null&&disposable.isDisposed()){
                    disposable.dispose();
                }
            }
        }
        mMap.clear();
    }
    public boolean idDispose(String tag){
        if(!mMap.isEmpty()&&mMap.get(tag)!=null){
            return mMap.get(tag).isDisposed();
        }
        return false;
    }
}
