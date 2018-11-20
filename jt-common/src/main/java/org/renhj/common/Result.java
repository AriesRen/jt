package org.renhj.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.renhj.enums.ResultCode;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2637853251723838658L;

    private Integer code=200;
    private String message="OK";
    private T data;

    public Result(T data){
        this.data = data;
    }

    public Result(Exception e){
        this.message = e.getMessage();
    }
    public Result(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(ResultCode code){
        this.code = code.getCode();
        this.message = code.getDesc();
    }
}
