package com.example.day1.activity.activity.model;

import com.example.day1.activity.activity.bean.NewsInfo;
import com.example.day1.activity.activity.bean.Result;
import com.example.day1.activity.activity.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class NewsModel {
    public static Result<NewsInfo> getNews(int page){
        String string = NetUtil.getInstance().doGet("http://47.94.132.125/baweiapi/gank_android?page="+page+"&pageSize=5");
        Gson gson = new Gson();
        Type type=new TypeToken<Result<NewsInfo>>(){}.getType();
         Result<NewsInfo> data= gson.fromJson(string, type);
         return data;
    }
}
