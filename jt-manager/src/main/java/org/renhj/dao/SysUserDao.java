package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysUser;

import java.util.List;

public interface SysUserDao {

    SysUser findUserById(Integer id);

    SysUser findUserByUsername(String username);

    List<SysUser> findUserWithPage(@Param("startIndex") Integer startIndex,
                                   @Param("pageSize")Integer pageSize,
                                   @Param("username")String username);

    int getRowCount(@Param("username")String username);

    int saveUser(SysUser user);

    int deleteUserById(Integer id);
}
