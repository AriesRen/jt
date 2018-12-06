package com.renhj.shiro.common;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Result implements Serializable {
    private Integer c = 200;
    private String m = "success";
    private Object d;

    public Result() {}

    public Result(Integer c, java.lang.String m, Object d) {
        this.c = c;
        this.m = m;
        this.d = d;
    }

    public Result(Object d) {
        this.d = d;
    }

    public Result(Throwable e) {
        this.c = 500;
        this.m = e.getMessage();
    }
}
