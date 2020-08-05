package com.example.callback;

import android.util.Log;

import com.example.exceptiopn.ExceptionEngine;
import com.google.gson.JsonElement;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseCallBack<T>extends BaseObserver {
    //解析成功的标志
    boolean callSucceess = true;

    @Override
    public void onNext(Object t) {
        super.onNext(t);
        Log.i("TAG", "onNext1"+t.toString());
        //返回的是json串
        T parse = parse((String)t);
        Log.i("TAG", "onNext"+parse.toString());
        if(callSucceess&&isCodeSucces()){
            onSuccess(parse);
        }
    }



    protected T parse(String result){
        T data = null;
        try {
            data = onConvert(result);
            callSucceess = true;
        } catch (Exception e) {
            e.printStackTrace();
            callSucceess= false;
            onError("解析数据错误", ExceptionEngine.ANALYTIC_SERVER_DATA_ERROR);
        }
        return data;
    }


    //数据返回状态成功
    protected abstract void onSuccess(T parse);

    //返回获取的泛型数据
    protected abstract boolean isCodeSucces();

    //将JsonElement转换为Response并通过子类来实现
    protected abstract T onConvert(String result);

    //将我们需要的数据解析出来
    public abstract T convert(JsonElement result);
}
