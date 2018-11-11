package org.renhj.controller;

import org.renhj.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/helloUI")
    public String helloUI(){
        return "sys/hello";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
