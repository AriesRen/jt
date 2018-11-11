package org.renhj.enums;

import org.renhj.common.Result;

public enum ResultCode {
    USERNAME_PASSWORD_ERROR(200, "用户名或密码错误!"),
    NOT_PERMISSION(401, "没有权限!"),
    FORBIDEN(403, "拒绝访问！");

    private Integer code;
    private String message;
    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    ResultCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
