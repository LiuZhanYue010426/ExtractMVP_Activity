package com.example.mvplibrary.liuzhanyue.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvplibrary.liuzhanyue.presenter.BasePresenter;
import com.example.mvplibrary.liuzhanyue.view.BaseView;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public abstract class BaseUserFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment {
    boolean mIsPrepare = false;//初始化视图
    boolean mIsVisible = false;//不可见
    boolean mIsFirstLoad = true;//第一次加载

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mIsPrepare = true;
        userLoad();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mIsVisible = true;
            userLoad();
        } else {
            mIsVisible = false;
        }
    }

    protected void userLoad() {
        if (mIsPrepare && mIsVisible && mIsFirstLoad) {
            lazyinitData();
            mIsFirstLoad = false;
        }
    }

    protected abstract void lazyinitData();

}
