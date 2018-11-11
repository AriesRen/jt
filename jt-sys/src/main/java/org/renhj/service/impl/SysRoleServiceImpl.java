package org.renhj.service.impl;

import org.renhj.dao.SysRoleDao;
import org.renhj.entity.SysRole;
import org.renhj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAllRoles() {
        try {
            return sysRoleDao.findAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<SysRole> findRolesWithPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public int deleteRoleById(Integer id) {
        return sysRoleDao.deleteRoleById(id);
    }

    @Override
    public int deleteAllByIds(Integer[] ids) {
        if (ids == null ||ids.length == 0){
            throw new IllegalArgumentException("未选中记录！");
        }
        return sysRoleDao.deleteAllByIds(ids);
    }

    @Override
    public int insertRole(SysRole role) {
        return sysRoleDao.insertRole(role);
    }
}
