package org.renhj.service.impl;

import org.junit.Test;
import org.renhj.TestBase;
import org.renhj.common.PageObject;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;

import java.util.Date;

public class SysLogsServiceImplTest extends TestBase {

    @Test
    public void findLogsByUsernameWithPage() {
        SysLogsService service = ctx.getBean("sysLogsServiceImpl", SysLogsService.class);
        PageObject<SysLogs> pageObject = service.findLogsByUsernameWithPage("", 1, 4);
        System.out.println(pageObject);
    }

    @Test
    public void rowCount(){
        SysLogsDao dao = (SysLogsDao) ctx.getBean("sysLogsDao");
        int i = dao.getRowCount("admin");
        System.out.println(i);
    }

    @Test
    public void saveLogs(){
        SysLogsDao dao = (SysLogsDao) ctx.getBean("sysLogsDao");
        SysLogs logs = new SysLogs();
        logs.setCreatedTime(new Date());
        logs.setIp("192.168.1.1");
        logs.setTime(1L);
        logs.setMethod(this.getClass().getSimpleName());
        logs.setParams("admin");
        logs.setOperation("测试操作");
        int i = dao.saveLogs(logs);
        System.out.println(i);
    }
}