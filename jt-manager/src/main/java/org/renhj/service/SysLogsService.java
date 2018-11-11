package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.entity.SysLogs;

public interface SysLogsService {
    PageObject<SysLogs> findLogsByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize);
}
