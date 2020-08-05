package com.example.extractmvp_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.callback.HttpCallBack;
import com.example.client.HttpClient;
import com.example.extractmvp_activity.app.ErgeBean;
import com.example.extractmvp_activity.base.MainPresenter;
import com.example.extractmvp_activity.base.MainView;
import com.example.mvplibrary.liuzhanyue.base.BaseMvpActivity;
import com.example.utils.JsonUtils;
import com.google.gson.JsonElement;

public class MainActivity extends BaseMvpActivity<MainView, MainPresenter> implements MainView{

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }*/

    @Override
    protected MainPresenter initPresenter() {
        mPresenter = new MainPresenter();
        return mPresenter;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSuccess(ErgeBean ergeBean) {
        Log.i("TAG", ergeBean.toString());
    }

    @Override
    public void onFail(String error) {
        Log.i("TAG", error);
    }
}
