package com.vc.mvpdemo.util;

import com.vc.mvpdemo.bean.Result;

public interface DataCall<T> {

    void success(Result<T> userList);
    void fail();
}
