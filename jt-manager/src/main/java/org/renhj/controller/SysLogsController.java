package org.renhj.controller;

import org.renhj.annotation.RequestLog;
import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/logs")
public class SysLogsController {

    @Autowired
    private SysLogsService sysLogsService;

    /** 获取所有日志 按照分页 */
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<PageObject<SysLogs>> logs(@RequestParam(value = "username", defaultValue = "")String username, @RequestParam(value = "pageCurrent", defaultValue = "1")Integer pageCurrent, @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){
        return new Result<PageObject<SysLogs>>(sysLogsService.findLogsByUsernameWithPage(username,pageCurrent, pageSize));
    }

    /** 获取某条日志 需要日志查看权限 */
    @ResponseBody
    @GetMapping("/{id}")
    public Result<SysLogs> getLogsOne(@PathVariable("id")Long id){
        return new Result<SysLogs>(200, "success", sysLogsService.findLogsById(id));
    }

    /** 删除某条日志 记录日志 需要权限日志删除权限 */
//    @RequestLog("删除日志")
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result<Integer> deleteLogs(@PathVariable("id")Long id){
        return new Result<Integer>(200, "删除成功！",sysLogsService.deleteLogsById(id));
    }
}
