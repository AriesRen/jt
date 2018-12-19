package org.renhj.service;

import org.apache.ibatis.annotations.Param;
import org.renhj.common.PageObject;
import org.renhj.entity.SysRole;

import java.util.Map;

public interface SysRoleService {
    Map<?, ?> findRolesWithPage(Integer pageCurrent, Integer pageSize);
}
