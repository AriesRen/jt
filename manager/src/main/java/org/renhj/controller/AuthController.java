package org.renhj.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.renhj.annotation.RequestLog;
import org.renhj.common.Result;
import org.renhj.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthController {

    @RequestMapping(value = "/loginUI", method = RequestMethod.GET)
    public String loginUI(){
        return "sys/login";
    }

    @ResponseBody
    @RequestLog("登录操作")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Object> doLogin(@RequestBody SysUser user){
        // 1、对用户输入数据进行封装
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 2、将用户信息提交到shiro
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        System.out.println(subject.getPrincipals());
        return new Result<Object>(200, "login success", subject.getPrincipals());
    }

    @RequestMapping("/")
    public String index(){
        return "sys/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Object> doLogout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result<Object>(200, "login success", "");
    }
}
