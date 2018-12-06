package com.renhj.shiro.mapper;

import com.renhj.shiro.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    List<SysUser> findAllUser();

    SysUser findUserByUsername(String username);

    int addUser(SysUser user);

    SysUser findUserById(Long registerUser);
}

