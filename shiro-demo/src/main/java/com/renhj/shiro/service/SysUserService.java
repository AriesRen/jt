package com.renhj.shiro.service;

import com.renhj.shiro.entity.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> findAllUser();

    Long registerUser(SysUser user);
}
