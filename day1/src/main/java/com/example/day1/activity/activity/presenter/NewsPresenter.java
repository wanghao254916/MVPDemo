package com.example.day1.activity.activity.presenter;

import com.example.day1.activity.activity.bean.NewsInfo;
import com.example.day1.activity.activity.bean.Result;
import com.example.day1.activity.activity.core.BasePresenter;
import com.example.day1.activity.activity.core.DataCall;
import com.example.day1.activity.activity.model.NewsModel;

public class NewsPresenter extends BasePresenter {
    public NewsPresenter(DataCall dataCall) {
        super(dataCall);
    }
    protected Result getModel(Object...args){
        return NewsModel.getNews((int)args[0]);
    }
}
