package org.renhj.controller;

import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysUser;
import org.renhj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/users")
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
    @GetMapping("")
    public Result<PageObject> getUserList(@RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                       @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                       @RequestParam(value = "username", defaultValue = "")String username){
        return new Result<PageObject>(sysUserService.findUsersByUsernameWithPage(username, pageCurrent, pageSize));
    }

    @PostMapping("")
    public Result<Object> postUser(SysUser user){
        sysUserService.saveUser(user);
        return null;
    }
}
