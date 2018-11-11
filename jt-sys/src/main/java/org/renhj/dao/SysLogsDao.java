package org.renhj.dao;

import org.apache.ibatis.annotations.Param;
import org.renhj.entity.SysLogs;

import java.util.List;

public interface SysLogsDao {

    SysLogs findLogById(Integer id);

    int insertLog(SysLogs sysLogs);

    List<SysLogs> findAllLogs();

    /**
     * 根据用户名查询分页日志数据
     * @param username 用户名
     * @param index 索引
     * @param pageSize 页面大小
     * @return 当前页的记录
     */
    List<SysLogs> findPageLogsByUsername(
            @Param("username") String username,
            @Param("index") Integer index,
            @Param("pageSize") Integer pageSize);

    /**
     * 获取总行数
     * @param username 用户名
     * @return 总行数
     */
    int getRowCount(@Param("username") String username);
}
