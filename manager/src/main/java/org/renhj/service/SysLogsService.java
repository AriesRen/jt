package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.entity.SysLogs;

public interface SysLogsService {
    PageObject<SysLogs> findLogsByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize);
    Integer deleteLogsById(Long id);

    SysLogs findLogsById(Long id);
}
