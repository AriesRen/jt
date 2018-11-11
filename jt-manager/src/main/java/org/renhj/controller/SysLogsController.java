package org.renhj.controller;

import org.junit.runners.Parameterized;
import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/")
public class SysLogsController {

    @Autowired
    private SysLogsService sysLogsService;

    @RequestMapping("logsUI")
    public String logsUI(){
        return "sys/index";
    }

    @RequestMapping(value = "logs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<PageObject<SysLogs>> logs(@RequestParam(value = "username", defaultValue = "")String username,
                                            @RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent,
                                            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize
                                   ){
        return new Result<PageObject<SysLogs>>(sysLogsService.findLogsByUsernameWithPage(username,pageCurrent, pageSize));
    }
}
