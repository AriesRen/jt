package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.entity.SysUser;

public interface SysUserService {
    PageObject<SysUser> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize);

    int saveUser(SysUser user);

    int deleteUser(Integer id);
}
