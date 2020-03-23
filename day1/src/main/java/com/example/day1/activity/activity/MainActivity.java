package com.example.day1.activity.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.day1.R;
import com.example.day1.activity.activity.adapter.MyBean;
import com.example.day1.activity.activity.bean.NewsInfo;
import com.example.day1.activity.activity.bean.Result;
import com.example.day1.activity.activity.core.BaseActivity;
import com.example.day1.activity.activity.core.DataCall;
import com.example.day1.activity.activity.presenter.NewsPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity implements DataCall<NewsInfo>{

    private PullToRefreshListView pullToRefreshListView;
    NewsPresenter newsPresenter;
    MyBean myBean;

    int page=1;
    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        newsPresenter = new NewsPresenter(this);
        pullToRefreshListView = findViewById(R.id.prlv);
        myBean = new MyBean();
        pullToRefreshListView.setAdapter(myBean);

        pullToRefreshListView.setMode(PullToRefreshListView.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                newsPresenter.request(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                newsPresenter.request(page);
            }
        });
        newsPresenter.request(page);
    }

    @Override
    public void success(Result<NewsInfo> result) {
        pullToRefreshListView.onRefreshComplete();
        if (result.code==200){
            if (page==1){
                myBean.clear();
            }
            myBean.addAll(result.result);
            myBean.notifyDataSetChanged();

        }
    }

    @Override
    public void fail() {
        pullToRefreshListView.onRefreshComplete();
        Toast.makeText(this,"加载失败",Toast.LENGTH_LONG).show();
    }
}
