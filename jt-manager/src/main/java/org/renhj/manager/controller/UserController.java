package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public Result users(){
        return Result.ok(userService.findAll());
    }
}
