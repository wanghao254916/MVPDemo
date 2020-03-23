package com.example.day1.activity.activity.core;

import com.example.day1.activity.activity.bean.Result;

public interface DataCall<T> {
    void success(Result<T> result);
    void fail();
}
