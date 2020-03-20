package com.vc.mvpdemo.bean;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    public String code;
    public List<T> listdata;
}
