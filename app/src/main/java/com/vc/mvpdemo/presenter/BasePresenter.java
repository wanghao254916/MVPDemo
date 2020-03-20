package com.vc.mvpdemo.presenter;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.vc.mvpdemo.bean.Result;
import com.vc.mvpdemo.model.UserModel;
import com.vc.mvpdemo.util.DataCall;

public abstract class BasePresenter {
    private DataCall dataCall;
    public BasePresenter(DataCall dataCall){
        this.dataCall = dataCall;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.obj!=null) {
                Result userList = (Result) msg.obj;
                dataCall.success(userList);
            }else{
                dataCall.fail();
            }
        }
    };

    public void request(final Object...args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //发送http请求
                //把子线程的请求结果发送到主线程更新到页面上
                Message message = Message.obtain();
                message.obj = getModel(args);
                handler.sendMessage(message);
            }
        }).start();
    }

    protected abstract Result getModel(Object...args);

    public void destory(){
        this.dataCall = null;
    }
}
