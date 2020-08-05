package com.example.extractmvp_activity.base;

import com.example.extractmvp_activity.app.ErgeBean;
import com.example.mvplibrary.liuzhanyue.view.BaseView;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public interface MainCallBack extends BaseView {
    void onSuccess(ErgeBean ergeBean);
    void onFail(String error);
}
