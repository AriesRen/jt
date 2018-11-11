package org.renhj.service.impl;

import org.junit.Test;
import org.renhj.TestBase;
import org.renhj.common.PageObject;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;

import static org.junit.Assert.*;

public class SysLogsServiceImplTest extends TestBase {

    @Test
    public void findLogsByUsernameWithPage() {
        SysLogsService service = ctx.getBean("sysLogsServiceImpl", SysLogsService.class);
        PageObject<SysLogs> pageObject = service.findLogsByUsernameWithPage("", 1, 4);
        System.out.println(pageObject);
    }
}