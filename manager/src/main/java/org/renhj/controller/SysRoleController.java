package org.renhj.controller;

import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.dao.SysRoleDao;
import org.renhj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<?> roleList(){
        return new Result<Object>(sysRoleService.findRolesWithPage(1, 10));
    }

}
