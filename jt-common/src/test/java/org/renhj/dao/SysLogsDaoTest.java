package org.renhj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SysLogsDaoTest {
    private static final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-configs.xml");


    @Test
    public void findLogsByUsernameWithPage() {
        SqlSessionFactory factory = ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession session = factory.openSession();
        SysLogsDao dao = session.getMapper(SysLogsDao.class);
        dao.findLogsByUsernameWithPage("admin", 0, 5);
        System.out.println(dao.findLogsByUsernameWithPage("admin", 0, 5));
        session.close();
        ctx.close();
    }

    @Test
    public void getRowCount() {
        SqlSessionFactory factory = ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession session = factory.openSession();
        SysLogsDao dao = session.getMapper(SysLogsDao.class);
        int i = dao.getRowCount("admin");
        System.out.println(i);

        session.close();
        ctx.close();
    }

    @Test
    public void saveLogs() {
    }
}