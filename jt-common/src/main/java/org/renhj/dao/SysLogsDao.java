package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysLogs;

import java.util.List;

public interface SysLogsDao {
    /**
     * 通过用户名查找日志并分页
     * @param username 用户名
     * @param startIndex 开始索引
     * @param endIndex 结束索引
     * @return sysLogs在区间startIndex到endIndex之间的数据
     */
    List<SysLogs> findLogsByUsernameWithPage(@Param("username") String username,
                                             @Param("startIndex") Integer startIndex,
                                             @Param("endIndex") Integer endIndex);

    int getRowCount(@Param("username") String username);

    /**
     * 保存日志
     * @param logs 日志对象
     * @return 执行结果
     */
    int saveLogs(SysLogs logs);
}
