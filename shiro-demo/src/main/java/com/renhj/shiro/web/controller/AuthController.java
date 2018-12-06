package com.renhj.shiro.web.controller;

import com.renhj.shiro.common.Result;
import com.renhj.shiro.entity.SysUser;
import com.renhj.shiro.mapper.SysUserMapper;
import com.renhj.shiro.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserMapper userMapper;

    @RequestMapping("login")
    public String loginUI(){
        return "login";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public Result doLogin(String username, String password){
        System.out.println(username + "  " + password);
        AuthenticationToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new Result(200,"success", subject.getSession());
    }

    @RequestMapping("unauth")
    @ResponseBody
    public Result unauth(){
        return new Result(401, "未登录",null);
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("doRegister")
    @ResponseBody
    public Result doRegister(SysUser user){
        return new Result(201, "register success" ,userMapper.findUserById(userService.registerUser(user)));
    }

}
