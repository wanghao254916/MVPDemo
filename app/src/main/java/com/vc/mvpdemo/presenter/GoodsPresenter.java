package com.vc.mvpdemo.presenter;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.vc.mvpdemo.bean.Goods;
import com.vc.mvpdemo.bean.Result;
import com.vc.mvpdemo.model.UserModel;
import com.vc.mvpdemo.util.DataCall;

public class GoodsPresenter extends BasePresenter {

    public GoodsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getModel(Object...args) {
        return UserModel.getGoodsList((String) args[0]);
    }

}
