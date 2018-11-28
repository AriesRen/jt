package org.renhj.controller;

import org.renhj.common.Result;
import org.renhj.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menus")
public class SysMenuController {
    @Autowired
    private SysMenuService menuService;

    @GetMapping("")
    public Result<Object> menus(){
        return new Result<Object>(200, "success",menuService.findAllMenus());
    }

}
