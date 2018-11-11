package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.entity.SysLogs;

import java.util.List;

public interface SysLogsService {
    int addLog(SysLogs logs);

    List<SysLogs> findAll();

    int getRowCount(String username);

    PageObject<SysLogs> findPageLogs(String username, Integer pageCurrent, Integer pageSize);
}
