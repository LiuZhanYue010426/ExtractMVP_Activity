package com.example.mvplibrary.liuzhanyue.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        unbinder = ButterKnife.bind(this);
        initEvent();
        initData();
    }

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract int initLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
