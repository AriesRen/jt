package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysRole;

import java.util.List;

public interface SysRoleDao {
    List<SysRole> findRoleByRoleWithPage(@Param("role")String role,
                                         @Param("startIndex")Integer startIndex,
                                         @Param("pageSize")Integer pageSize);

    int saveRole(SysRole role);

    int deleteRoleById(Integer id);

    int updateRole(SysRole role);
}
