package com.renhj.shiro.web.exception;

import com.renhj.shiro.common.Result;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        return new Result(e);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public Result exceptionHandler(IncorrectCredentialsException e){
        return new Result(400001, "账号或密码不正确！", null);
    }

}
