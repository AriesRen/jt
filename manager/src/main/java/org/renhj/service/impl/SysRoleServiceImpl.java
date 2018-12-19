package org.renhj.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.renhj.common.PageObject;
import org.renhj.dao.SysRoleDao;
import org.renhj.entity.SysRole;
import org.renhj.service.SysRoleService;
import org.renhj.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao roleDao;

    @Override
    public Map<String, Object> findRolesWithPage(Integer pageCurrent, Integer pageSize) {
        int rowsCount = roleDao.getRowCount();

        HashMap<String,Object> map = new HashMap<>();
        map.put("row", rowsCount);
        map.put("pageCurrent", pageCurrent);
        map.put("pageSize", pageSize);
        map.put("records",roleDao.findRolesWithPage((pageCurrent-1)*pageSize, pageSize));
        map.put("pageCount", (rowsCount-1)/pageSize+1);

        return map;
    }
}
