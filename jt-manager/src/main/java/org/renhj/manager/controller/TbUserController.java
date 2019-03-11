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
        return Result.build(200, "save ok", userService.saveUser(user));
    }

    /**
     * 通过ID获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return Result.ok(userService.findUserById(id));
    }

    @GetMapping("/isExistUser")
    public Result getUserByUsername(String username){
        return Result.ok(userService.findUserByUsername(username));
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否成功
     */
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return Result.build(200, "delete ok", userService.deleteUserById(id));
    }

    /**
     * 修改用户信息  冥等
     * @param user 修改用户的所有信息
     * @return 是否修改成功
     */
    @PutMapping("/{id}")
    public Result updateUser(@RequestBody TbUser user) {
        return Result.build(200, "update ok", userService.updateUser(user));
    }

    /**
     * 修改用户信息 非冥等
     * @param user 用户信息 通过spinrg获取需要修改的用户信息，构造user对象
     * @return 是否修改成功
     */
    @PatchMapping("/{id}")
    public Result patchUser(@RequestBody TbUser user, @PathVariable("id") Long userId) {
        user.setId(userId);
        System.out.println(user);
        return Result.build(200, "patch ok", userService.patchUser(userId, user));
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
