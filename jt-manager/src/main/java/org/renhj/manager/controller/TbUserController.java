package org.renhj.manager.controller;


import org.renhj.common.pojo.vo.Result;
import org.renhj.common.utils.convert.MapObjectConvert;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class TbUserController {
    @Autowired
    private TbUserService userService;

    @GetMapping
    public Result users(@RequestParam(value = "current", defaultValue = "1") Integer pageCurrent,
                        @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
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

    @GetMapping("/info")
    public Result userInfo(@RequestParam String token){
        Map<String, Object> map = null;
        try {
            map = MapObjectConvert.object2Map(userService.findUserById(1L));
            List<String> roles = new ArrayList<>();
            roles.add("admin");
            roles.add("editor");
            roles.add("system");
            map.put("roles", roles);
            return Result.ok(map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Result.build(401, "获取用户信息失败！", "");
        }
    }
}
