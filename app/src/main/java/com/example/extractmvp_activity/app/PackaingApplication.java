package com.example.extractmvp_activity.app;

import android.app.Application;

import com.example.HttpConstant;
import com.example.HttpGlobalConfig;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class PackaingApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        String FULI="https://gank.io/";
        String ERGE="http://api_q.ergedd.com/api/v1/albums/1/";
        HttpGlobalConfig.getInstance()
                .setBaseUrl(ERGE)
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
    }
}
