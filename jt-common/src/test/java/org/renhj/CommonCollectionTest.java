package org.renhj;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonCollectionTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-configs.xml");
        SysLogsDao dao = ctx.getBean("sysLogsDao", SysLogsDao.class);
        int i = dao.getRowCount("admin");
        System.out.println(i);
        ctx.close();
    }

}
