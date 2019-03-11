package org.renhj.manager.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"/spring/*.xml"})
public class TbUserServiceImplTest {
    @Autowired
    private TbUserService userService;

    @Test
    public void findUsersByUsernameWithPage() {
        System.out.println(userService);
        Page page = userService.findUsersByUsernameWithPage("", 1, 5);
        System.out.println(page);
    }
}