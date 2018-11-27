package org.renhj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysUser;
import org.renhj.exception.ResourceNotExistException;
import org.renhj.service.SysUserService;
import org.renhj.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户信息 分页
     * @param pageCurrent 当前页码  默认为1
     * @param pageSize 页面大小 默认为5
     * @param username 模糊查询用户名 默认为""
     * @return pageObjectd 的 result对象
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<?> getUserList(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                       @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                       @RequestParam(value = "username", defaultValue = "")String username) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        return new Result<>(sysUserService.findUsersByUsernameWithPage(username, pageCurrent, pageSize));
    }

    @PostMapping(value = "")
    @ResponseBody
    public Result<Object> postUser(@RequestBody Map<String, Object> map){
        System.out.println(map);
        System.out.println(map.get("user"));
        SysUser user = JsonUtils.map2Obj((Map<?, ?>) map.get("user"), SysUser.class);
        System.out.println(user);
        System.out.println(map.get("roleIds"));
        System.out.println(map.get("roleIds") instanceof String);
        System.out.println(map.get("roleIds") instanceof ArrayList);

        return new Result<Object>(201, "save ok", map);
//        return new Result<Object>(201, "save ok", sysUserService.saveUser(user, roleIds));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result<SysUser> getUser(@PathVariable("id")Long id){
        return new Result<SysUser>(200, "success",sysUserService.findUserById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Result<Object> deleteUser(@PathVariable("id")Long id){
        return new Result<Object>(sysUserService.deleteUser(id));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Result<?> updateUser(@PathVariable("id")Long id, @RequestBody SysUser user){
        System.out.println(user);
        System.out.println(id);
        SysUser validUser = sysUserService.findUserById(id);
        validUser.setStatus(user.getStatus());
        sysUserService.updateUser(validUser);
        return new Result<>(200, "update ok", "");
    }

}
