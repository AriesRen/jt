package org.renhj.dao;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
    int insertUserRole(@Param("userId") Long userId,@Param("roleIds") Long[] roleIds);

    Long[] findRoleIdsByUserId(@Param("userId") Long userId);
}
