package com.example.mvplibrary.liuzhanyue.base;

import com.example.mvplibrary.liuzhanyue.presenter.BasePresenter;
import com.example.mvplibrary.liuzhanyue.view.BaseView;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment {
    public P mPresenter;

    @Override
    protected void initData() {
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    protected abstract P initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.destoryView();
            mPresenter = null;
        }
    }
}
