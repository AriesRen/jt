package org.renhj.dao;

import org.renhj.entity.SysUser;

public interface SysUserDao {

    SysUser findUserById(Integer id);

    SysUser findUserByUsername(String username);

}
