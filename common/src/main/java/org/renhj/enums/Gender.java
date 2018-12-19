package org.renhj.enums;

import org.renhj.base.BaseEnum;

public enum Gender implements BaseEnum {
    MALE(0,"男"),
    FEMALE(1,"女");

    private int code;
    private String desc;
    Gender(int code, String desc){
        this.desc = desc;
        this.code = code;
    }

    public int getCode(){return code;}

    @Override
    public String getDesc() {
        return desc;
    }

}
