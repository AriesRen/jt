package com.renhj.shiro.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private Date createdTime;
    private String createdUser;
    private Date updatedTime;
    private String updatedUser;
}
