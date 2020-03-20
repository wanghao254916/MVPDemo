package com.vc.mvpdemo.presenter;

import com.vc.mvpdemo.bean.Result;
import com.vc.mvpdemo.util.DataCall;
import com.vc.mvpdemo.model.UserModel;

public class UserPresenter extends BasePresenter {
    public UserPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getModel(Object...args) {
        return UserModel.getUserList((String)args[0],(String)args[1]);
    }
}
