package org.renhj.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1387903758987079211L;
    private Integer id;
    private String name;
    private String note;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
}
