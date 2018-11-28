package org.renhj.dao;

import org.renhj.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuDao {
    List<Map<String, Object>> findAllMenus();
}
