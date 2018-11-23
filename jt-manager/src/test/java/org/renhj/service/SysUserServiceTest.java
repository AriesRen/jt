package org.renhj.service;

import org.junit.Before;
import org.junit.Test;
import org.renhj.TestBase;
import org.renhj.common.PageObject;
import org.renhj.entity.SysLogs;
import org.renhj.entity.SysUser;
import org.renhj.enums.UserStatus;

import java.util.Date;

import static org.junit.Assert.*;

public class SysUserServiceTest extends TestBase {

    @Test
    public void saveUser() {
        SysUserService service = ctx.getBean("sysUserServiceImpl", SysUserService.class);
        SysUser user = new SysUser();
        user.setUsername("renhj");
        user.setStatus(UserStatus.ACTIVE);
        user.setPassword("123456");
        user.setSalt("123456");
        user.setEmail("renhj@163.com");
        user.setPhone("12222222");
        user.setUpdatedUser("admin");
        user.setCreatedUser("admin");
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        Long[] l1 = new Long[] {1L, 2L};
        service.saveUser(user, l1);
        System.out.println(user);
    }

    @Test
    public void deleteUser(){
        SysUserService service = ctx.getBean("sysUserServiceImpl", SysUserService.class);
        int i = service.deleteUser(2L);
        System.out.println(i);
    }


}