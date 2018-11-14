package org.renhj.entity;

import lombok.Data;
import org.renhj.enums.UserStatus;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -7107295446381123401L;

    private Integer id;              // ID
    private String username;        // 用户名
    private String password;        // 用户密码
    private String salt;            // 密码加密盐
    private UserStatus status;      // 账户状态（0 未激活， 1 激活， 2 锁定）
    private String email;           // 邮箱
    private String phone;           // 电话
    private Date createdTime;      // 创建时间
    private String createdUser;    // 谁创建的
    private Date updatedTime;      // 修改时间
    private String updatedUser;    // 修改用户
}
