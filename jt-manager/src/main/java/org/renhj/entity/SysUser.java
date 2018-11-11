package org.renhj.entity;

import lombok.Data;
import org.renhj.enums.UserStatus;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -7107295446381123401L;

    private Integer id;              // ID
    private String username;        // 用户名
    private String password;        // 用户密码
    private String salt;            //  密码加密盐
    private UserStatus status;          //  账户状态（0 未激活， 1 激活， 2 锁定）

}
