package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysRole;

import java.util.List;

public interface SysRoleDao {
    List<SysRole> findAllRoles();

    List<SysRole> findRolesWithPage(@Param("page") Integer page, @Param("size") Integer size);

    SysRole findRoleById(Integer id);

    int insertRole(SysRole role);

    int deleteRoleById(Integer id);

    int deleteAllByIds(Integer[] ids);
}
