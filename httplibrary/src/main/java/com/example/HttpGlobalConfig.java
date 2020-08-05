package com.example;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class HttpGlobalConfig {
    //baseUrl
    private String baseUrl;
    private long timeout;
    private TimeUnit timeUnit;
    //公共请求参数
    private Map<String,Object> baseParams;
    //公共的请求头信息
    private Map<String,Object> baseHeades;
    //公共的拦截器
    private List<Interceptor> interceptors;
    //日志开关
    private boolean isShowLog;
    private Context context;
    private Handler handler;
    private HttpGlobalConfig(){

    }
    //静态内部类
    private static final class HttpGlobalConfigHodler{
        private static HttpGlobalConfig INSTANCE = new HttpGlobalConfig();
    }

    public static HttpGlobalConfig getInstance(){
        return HttpGlobalConfigHodler.INSTANCE;
    }
    public String getBaseUrl(){
        return baseUrl;
    }

    public HttpGlobalConfig setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
        return HttpGlobalConfig.getInstance();
    }

    public long getTimeout(){
        return timeout;
    }
    public HttpGlobalConfig setTimeout(long timeout){
        this.timeout=timeout;
        return HttpGlobalConfig.getInstance();
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public HttpGlobalConfig setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return HttpGlobalConfig.getInstance();
    }

    public Map<String, Object> getBaseparams() {
        return baseParams;
    }

    public HttpGlobalConfig setBaseparams(Map<String, Object> baseparams) {
        this.baseParams = baseparams;
        return HttpGlobalConfig.getInstance();
    }

    public Map<String, Object> getBaseHeades() {
        return baseHeades;
    }

    public HttpGlobalConfig setBaseHeades(Map<String, Object> baseHeades) {
        this.baseHeades = baseHeades;
        return HttpGlobalConfig.getInstance();
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public HttpGlobalConfig setInterceptors(ArrayList<Interceptor> interceptors) {
        this.interceptors = interceptors;
        return HttpGlobalConfig.getInstance();
    }

    public boolean isShowLog() {
        return isShowLog;
    }

    public HttpGlobalConfig setShowLog(boolean showLog) {
        this.isShowLog = showLog;
        return HttpGlobalConfig.getInstance();
    }

    public HttpGlobalConfig initReady(Context context) {
        this.context = context.getApplicationContext();
         handler = new Handler(Looper.getMainLooper());
        return HttpGlobalConfig.getInstance();
    }

    public Context getContext() {
        return context;
    }

    public Handler getHandler() {
        return handler;
    }
}
