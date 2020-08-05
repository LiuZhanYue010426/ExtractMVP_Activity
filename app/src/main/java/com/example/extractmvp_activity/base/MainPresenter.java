package com.example.extractmvp_activity.base;

import com.example.extractmvp_activity.app.ErgeBean;
import com.example.mvplibrary.liuzhanyue.model.ModelFractory;
import com.example.mvplibrary.liuzhanyue.presenter.BasePresenter;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class MainPresenter extends BasePresenter<MainView> implements MainCallBack {
    public void getData(){
        ModelFractory.createModel(MainModel.class).getData(this);
    }
    @Override
    public void onSuccess(ErgeBean ergeBean) {
        mView.onSuccess(ergeBean);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }
}
