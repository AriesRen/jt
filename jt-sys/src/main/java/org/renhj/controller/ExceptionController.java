package org.renhj.controller;

import org.renhj.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public Result golbalException(Exception e){
        Result result =  new Result<>();
        result.setCode(500);
        result.setMessage(e.getMessage());
        return result;
    }
}
