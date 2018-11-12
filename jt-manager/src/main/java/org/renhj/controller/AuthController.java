package org.renhj.controller;

import org.renhj.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "sys/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(String username, String password){
        System.out.println(username + "" + password);
        return new Result<String>("login success");
    }

    @RequestMapping("/")
    public String index(){
        return "sys/index";
    }
}
