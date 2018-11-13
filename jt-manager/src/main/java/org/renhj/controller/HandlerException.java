package org.renhj.controller;

import org.renhj.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e){
        return new Result<String>(500, e.getMessage(), "");
    }


}
