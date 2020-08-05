package com.example.callback;

import android.util.Log;

import com.example.demo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    Response response;

    @Override
    protected T onConvert(String result) {
        T t = null;
        response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        int errorCode = response.getErrorCode();
        String errorMsg = response.getErrorMsg();
        switch (errorCode) {
            case -1:
                onError(errorMsg, errorCode);
                break;
            default:
                if (isCodeSucces()) {
                    t = convert(data);
                }
                break;
        }
        Log.i("TAG", "onConvert" + t.toString());
        return t;
    }

    @Override
    protected boolean isCodeSucces() {
        if (response != null) {
            return response.getErrorCode() == 0;
        }
        return false;
    }
}
