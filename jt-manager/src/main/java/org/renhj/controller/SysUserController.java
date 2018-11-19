package org.renhj.controller;

import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysUser;
import org.renhj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Result<PageObject> getUserList(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                       @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                       @RequestParam(value = "username", defaultValue = "")String username){
        return new Result<PageObject>(sysUserService.findUsersByUsernameWithPage(username, pageCurrent, pageSize));
    }

    @PostMapping(value = "")
    @ResponseBody
    public Result<Object> postUser(SysUser user){
        sysUserService.saveUser(user);
        return new Result<Object>(201, "save ok", user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Result<Object> deleteUser(@PathVariable("id")Integer id){
        return new Result<Object>(sysUserService.deleteUser(id));
    }

}
