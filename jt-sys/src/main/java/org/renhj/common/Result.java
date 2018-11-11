package org.renhj.common;

import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2637853251723838658L;

    private int code = 200;
    private String message="success";
    private T data;
    public Result(){}
    public Result(T data){
        this.data = data;
    }
    public Result(Throwable t){
        this.code = 500;
        this.message = t.getMessage();
    }
}
