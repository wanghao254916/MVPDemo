package com.vc.mvpdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vc.mvpdemo.bean.Goods;
import com.vc.mvpdemo.bean.Result;
import com.vc.mvpdemo.bean.User;
import com.vc.mvpdemo.presenter.GoodsPresenter;
import com.vc.mvpdemo.util.DataCall;
import com.vc.mvpdemo.R;
import com.vc.mvpdemo.presenter.UserPresenter;

public class MainActivity extends BaseActivity implements DataCall<User> {

    private TextView textView;
    private UserPresenter presenter;
    private GoodsPresenter goodsPresenter;

    //java默认请求类：HttpUrlConnection
    //网络请求框架：Volley,OKHttp,Retrofit
    @Override
    protected void initView(Bundle savedInstanceState) {
        textView = findViewById(R.id.text);
        presenter = new UserPresenter(this);
        goodsPresenter = new GoodsPresenter(new DataCall<Goods>() {
            @Override
            public void success(Result<Goods> userList) {

            }

            @Override
            public void fail() {

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.request("13126965104","123456");
                goodsPresenter.request("1000232");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Result<User> userList) {
        textView.setText(userList.code+"   "+userList.listdata.size());
    }

    @Override
    public void fail() {
        textView.setText("请求失败");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
    }
}
