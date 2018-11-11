package org.renhj.dao;

import org.renhj.entity.SysUser;

public interface SysUserDao {

    SysUser findUserByUsername(String username);
}
