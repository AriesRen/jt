package org.renhj.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.renhj.common.Result;
import org.renhj.exception.ResourceNotExistException;
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

    @ExceptionHandler(ResourceNotExistException.class)
    @ResponseBody
    public Result<String> ServiceExceptionHandler(ResourceNotExistException e){
        return new Result<String>(404, e.getMessage(), "");
    }

    @ExceptionHandler({UnknownAccountException.class, DisabledAccountException.class, LockedAccountException.class, AuthenticationException.class})
    @ResponseBody
    public Result<String> ServiceExceptionHandler(Exception e){
        return new Result<String>(401, e.getMessage(), "");
    }

}
