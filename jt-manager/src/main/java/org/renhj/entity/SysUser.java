package org.renhj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.renhj.base.BaseEntity;
import org.renhj.enums.UserStatus;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseEntity{
    private static final long serialVersionUID = -7107295446381123401L;

    private Long id;              // ID
    private String username;        // 用户名
    private String password;        // 用户密码
    private String salt;            // 密码加密盐
    private UserStatus status;      // 账户状态（0 未激活， 1 激活， 2 锁定）
    private String email;           // 邮箱
    private String phone;           // 电话
}
