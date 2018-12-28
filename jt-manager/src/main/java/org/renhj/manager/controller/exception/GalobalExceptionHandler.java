package org.renhj.manager.controller.exception;

import org.renhj.common.pojo.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GalobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        return Result.build(500, e.getMessage(), "");
    }
}
