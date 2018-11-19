package org.renhj.enums;

import org.renhj.base.BaseEnum;


public enum ResultCode implements BaseEnum {
    USERNAME_PASSWORD_ERROR(200, "用户名或密码错误!"),
    NOT_PERMISSION(401, "没有权限!"),
    FORBIDEN(403, "拒绝访问！");

    private int code;
    private String desc;
    ResultCode(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    ResultCode(Integer code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
