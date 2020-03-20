package com.vc.mvpdemo.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vc.mvpdemo.bean.Goods;
import com.vc.mvpdemo.bean.Result;
import com.vc.mvpdemo.bean.User;
import com.vc.mvpdemo.util.NetUtil;

import java.lang.reflect.Type;

public class UserModel {

    public static Result<User> getUserList(String phone,String pas){
        String result = NetUtil.getInstance().doGet("http://blog.zhaoliang5156.cn/api/news/lawyer2.json");
        Gson gson = new Gson();
        Type jsonType = new TypeToken<Result<User>>(){}.getType();
        Result<User> userList = gson.fromJson(result,jsonType);
        return userList;
    }
    public static Result<Goods> getGoodsList(String id){
        String result = NetUtil.getInstance().doGet("http://blog.zhaoliang5156.cn/api/news/lawyer2.json");
        Gson gson = new Gson();
        Type jsonType = new TypeToken<Result<Goods>>(){}.getType();
        Result<Goods> userList = gson.fromJson(result,jsonType);
        return userList;
    }

}
