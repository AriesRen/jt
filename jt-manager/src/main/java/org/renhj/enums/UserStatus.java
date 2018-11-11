package org.renhj.enums;

import org.springframework.web.util.pattern.PathPattern;

public enum  UserStatus{
    NOACTIVE(0), ACTIVE(1), LOCKED(2);

    private Integer status;
    UserStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }
}
