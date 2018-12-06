package com.renhj.shiro.service.impl;

import com.renhj.shiro.entity.SysUser;
import com.renhj.shiro.mapper.SysUserMapper;
import com.renhj.shiro.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public Long registerUser(SysUser user) {
        // 判断是否存在同名用户
        SysUser su = userMapper.findUserByUsername(user.getUsername());
        if (su!=null) throw new AuthenticationException("该用户已存在！");

        String salt = UUID.randomUUID().toString().replace("-", "");
        user.setPassword(new SimpleHash("MD5", user.getPassword(), salt, 2).toHex());
        user.setSalt(salt);
        user.setStatus(1);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(user.getCreatedTime());
        user.setCreatedUser("admin");
        user.setUpdatedUser("admin");

        int i = userMapper.addUser(user);
        if (i!=1) throw new RuntimeException("未知错误！");
        return user.getId();
    }
}
