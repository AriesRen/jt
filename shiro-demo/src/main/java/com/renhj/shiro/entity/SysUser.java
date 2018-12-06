package com.renhj.shiro.entity;

import com.renhj.shiro.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String salt;
    private Integer status;
}
