package org.renhj;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
    protected ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
    }

    @After
    public void after(){
        ctx.close();
    }
}
