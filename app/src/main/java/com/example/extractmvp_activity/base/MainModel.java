package com.example.extractmvp_activity.base;

import android.util.Log;

import com.example.callback.HttpCallBack;
import com.example.client.HttpClient;
import com.example.extractmvp_activity.app.ErgeBean;
import com.example.mvplibrary.liuzhanyue.model.BaseModel;
import com.example.utils.JsonUtils;
import com.google.gson.JsonElement;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class MainModel implements BaseModel {
    public void getData(MainCallBack mainCallBack){
        String FULI = "api/data/福利/20/20";
        new HttpClient.Builder()
                .setApiUrl("comments")
                .get()
                // .setJsonBody("",true)
                .build()
                .request(new HttpCallBack<ErgeBean>() {

                    @Override
                    public void onError(String message, int code) {
                        Log.e("TAG", "onError" + message + code);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(ErgeBean ergeBean) {
                        Log.e("TAG", ergeBean.toString());
                    }

                    @Override
                    public ErgeBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, ErgeBean.class);
                    }
                });
    }
}
