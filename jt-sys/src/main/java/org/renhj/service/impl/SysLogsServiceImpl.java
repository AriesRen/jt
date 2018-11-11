package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.WebServiceException;
import java.util.List;

/**
 * 事务：逻辑单元
 * 特性：ACID 原子性、一致性、隔离性、
 * 控制：编程式事务   声明式事务（spring aop）
 * 实现：xml  annotation
 *
 * Transactional：声明式事务
 * 可以配置在类上（共性），也可以配置在方法上（特性）
 *
 * 1）readonly：只读属性，默认是false，常用在查询中
 * 2）timeout：事务执行超时时间
 * 3）rollbackFor：出现什么异常回滚
 * 4）isolation：隔离级别
 * 5）propagation: 事务的传播特性
 *
 * 事务的四个隔离级别和出现的情况
 * 1）read-uncommited 读未提交 脏读
 * 2）read-commited 读已提交 可重复度
 * 3）repeatable-read 可重复读 幻读
 * 4）serializable 序列化读
 */
@Transactional(rollbackFor = Throwable.class, timeout = 30, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
@Service
public class SysLogsServiceImpl implements SysLogsService {
    @Autowired
    private SysLogsDao sysLogsDao;

    @Override
    public int addLog(SysLogs logs) {
        return sysLogsDao.insertLog(logs);
    }

    public List<SysLogs> findAll(){
        return sysLogsDao.findAllLogs();
    }

    @Override
    public int getRowCount(String username) {
        return sysLogsDao.getRowCount(username);
    }

    @Override
    @Transactional(readOnly = true)
    public PageObject<SysLogs> findPageLogs(String username, Integer pageCurrent, Integer pageSize) {
        // 1、验证参数
        if (pageCurrent== null || pageCurrent <1) throw new IllegalArgumentException("pageCurrent 参数不合法");
        // 2、查询总记录数
        int rowCount = sysLogsDao.getRowCount(username);
        if (rowCount==0) throw new WebServiceException("未找到记录！");
        // 3、查询当前页
        int index = (pageCurrent -1)* pageSize;
        List<SysLogs> list = sysLogsDao.findPageLogsByUsername(username, index, pageSize);
        return new PageObject<>(pageCurrent, pageSize, rowCount, (rowCount-1)/pageSize +1, list);
    }
}
