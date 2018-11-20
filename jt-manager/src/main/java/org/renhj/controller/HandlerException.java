package org.renhj.controller;

import org.renhj.common.Result;
import org.renhj.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> exceptionHandler(Exception e){
        return new Result<String>(500, e.getMessage(), "");
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result<String> ServiceExceptionHandler(ServiceException e){
        return new Result<String>(500, e.getMessage(), "");
    }

}
