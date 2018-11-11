package org.renhj.controller;

import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/json")
@Controller
public class JsonController {

    @RequestMapping("/json1")
    @ResponseBody
    public Map<String, Object> json1(){
        Map<String, Object> map =  new HashMap<>();
        map.put("id", 10);
        map.put("姓名", "json test");
        map.put("年龄", 23);
        return map;
    }

}
