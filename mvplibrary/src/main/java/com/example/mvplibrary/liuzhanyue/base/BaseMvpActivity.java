package com.example.mvplibrary.liuzhanyue.base;

import com.example.mvplibrary.liuzhanyue.presenter.BasePresenter;
import com.example.mvplibrary.liuzhanyue.view.BaseView;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {
    public P mPresenter;

    @Override
    protected void initEvent() {
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destoryView();
            mPresenter = null;
        }
    }
}
