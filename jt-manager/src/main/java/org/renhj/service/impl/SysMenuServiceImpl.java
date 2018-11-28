package org.renhj.service.impl;

import org.renhj.dao.SysMenuDao;
import org.renhj.entity.SysMenu;
import org.renhj.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao menuDao;

    @Override
    public List<Map<String, Object>> findAllMenus() {
        return menuDao.findAllMenus();
    }
}
