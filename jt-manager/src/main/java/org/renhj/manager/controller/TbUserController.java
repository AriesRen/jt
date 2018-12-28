package org.renhj.manager.controller;


import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TbUserController {
    @Autowired
    private TbUserService userService;

    @GetMapping
    public Result users(@RequestParam(value = "pageCurrent", defaultValue = "1") Integer pageCurrent,
                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                        @RequestParam(value = "username", defaultValue = "") String username) {
        return Result.ok(userService.findUsersByUsernameWithPage(username, pageCurrent, pageSize));
    }

    @PostMapping
    public Result addUsers(@RequestBody TbUser user) {
        return Result.build(201, "save ok", userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return Result.ok(userService.findUserById(id));
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return Result.build(200, "delete ok", userService.deleteUserById(id));
    }

    @PutMapping("/{id}")
    public Result updateUser(@RequestBody TbUser user) {
        return Result.build(200, "update ok", userService.updateUser(user));
    }

    @PatchMapping("/{id}")
    public Result patchUser(@RequestBody TbUser user) {
        return Result.build(200, "patch ok", userService.updateUser(user));
    }
}
