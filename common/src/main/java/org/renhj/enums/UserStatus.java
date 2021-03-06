package org.renhj.enums;


import org.renhj.base.BaseEnum;

public enum  UserStatus implements BaseEnum {
    NOACTIVE(0, "未激活"), ACTIVE(1, "已激活"), LOCKED(2, "已锁定");

    private final int code;
    private final String desc;
    UserStatus(int code, String desc){
        this.desc = desc;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
