package org;

import org.renhj.service.SysLogsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SysLogsServiceTest {

    @org.junit.Test
    public void getRowCount() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
        SysLogsService sysLogsService = (SysLogsService) ctx.getBean("sysLogsService");
        int row  = sysLogsService.getRowCount("admin");
        System.out.println(row);

    }

    @org.junit.Test
    public void findPageLogs() {
    }
}