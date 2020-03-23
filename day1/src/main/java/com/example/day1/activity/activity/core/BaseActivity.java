package com.example.day1.activity.activity.core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        initView(savedInstanceState);
    }

    protected abstract int getlayout();

    protected abstract void initView(Bundle savedInstanceState);


}
