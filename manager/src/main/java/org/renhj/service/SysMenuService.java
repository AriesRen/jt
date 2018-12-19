package org.renhj.service;

import org.renhj.entity.SysMenu;

import java.util.List;
import java.util.Map;


public interface SysMenuService {
    List<Map<String, Object>> findAllMenus();
}
