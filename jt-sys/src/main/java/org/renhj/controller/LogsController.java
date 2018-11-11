package org.renhj.controller;

import org.renhj.common.PageObject;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/logs/")
public class LogsController {
    @Autowired
    private SysLogsService sysLogsService;

    @RequestMapping("logsUI")
    public String logs(){
        return "sys/_logs";
    }


    @RequestMapping("count")
    @ResponseBody
    public int count(){
        return sysLogsService.getRowCount("admin");
    }

    @RequestMapping("page")
    @ResponseBody
    public PageObject<SysLogs> page(@RequestParam(value = "username", defaultValue = "")String username,
                                    @RequestParam(value = "pageCurrent", defaultValue = "1")int pageCurrent,
                                    @RequestParam(value = "pageSize", defaultValue = "5")int pageSize){
        System.out.println(username + " " + pageCurrent+" "+pageSize);
        return sysLogsService.findPageLogs(username, pageCurrent, pageSize);
    }
}
