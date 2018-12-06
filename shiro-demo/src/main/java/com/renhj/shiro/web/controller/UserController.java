package com.renhj.shiro.web.controller;

import com.renhj.shiro.common.Result;
import com.renhj.shiro.mapper.SysUserMapper;
import com.renhj.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("")
    public Result users(){
        return new Result(userService.findAllUser());
    }

}
