package org.renhj.dao;

import org.junit.Test;
import org.renhj.TestBase;
import org.renhj.entity.SysUser;
import org.renhj.enums.UserStatus;
import org.renhj.utils.EnumUtils;

import static org.junit.Assert.*;

public class SysUserDaoTest extends TestBase {

    @Test
    public void findUserById() {
        SysUserDao dao = ctx.getBean("sysUserDao", SysUserDao.class);
        SysUser user = dao.findUserById(1L);
        System.out.println(user);
    }

    @Test
    public void findUserByUsername() {
        String s  = EnumUtils.codeOf(UserStatus.class, 1).getDesc();
        System.out.println(s);
    }

    @Test
    public void updateUser() {
        SysUserDao dao = ctx.getBean("sysUserDao", SysUserDao.class);
        SysUser user = dao.findUserById(1L);
        System.out.println(user);
        user.setStatus(0);
        user.setUpdatedUser("admin");
        int i = dao.updateUser(user);
        System.out.println(i);
    }
}