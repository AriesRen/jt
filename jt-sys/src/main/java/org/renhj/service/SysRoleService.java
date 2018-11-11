package org.renhj.service;

import org.renhj.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    List<SysRole> findAllRoles();
    List<SysRole> findRolesWithPage(Integer page, Integer size);
    int deleteRoleById(Integer id);
    int deleteAllByIds(Integer[] ids);
    int insertRole(SysRole role);
}
