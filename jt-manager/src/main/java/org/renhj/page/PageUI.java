package org.renhj.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageUI {

    @RequestMapping("/index")
    public String index(){
        return "sys/index1";
    }

    @RequestMapping("/logsUI")
    public String logsUI(){
        return "sys/_logs";
    }

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "sys/login";
    }

    @RequestMapping("/roleUI")
    public String roleUI(){
        return "sys/_table";
    }
    @RequestMapping("/addRoleUI")
    public String addRoleUI(){
        return "sys/_addRole";
    }

    @RequestMapping("/menuUI")
    public String menuUI(){
        return "sys/_menu";
    }
}
