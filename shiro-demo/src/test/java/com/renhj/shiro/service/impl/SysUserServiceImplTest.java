package com.renhj.shiro.service.impl;

import com.renhj.shiro.ShiroDemoApplication;
import com.renhj.shiro.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ShiroDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService userService;

    @Test
    public void findAllUser() {
        System.out.println(userService.findAllUser());
    }
}