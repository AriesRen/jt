package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.renhj.exception.ServiceException;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;

@Service
public class SysLogsServiceImpl implements SysLogsService {

    @Autowired
    private SysLogsDao sysLogsDao;

    @Override
    public PageObject<SysLogs> findLogsByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        try {
            int rowCount = sysLogsDao.getRowCount(username);
            int pageCount = (rowCount -1)%pageSize + 1;

            PageObject<SysLogs> pageObject = new PageObject<>();
            pageObject.setPageCurrent(pageCurrent);
            pageObject.setRow(rowCount);
            pageObject.setPageCount(pageCount);
            pageObject.setPageSize(pageSize);
            pageObject.setRecords(sysLogsDao.findLogsByUsernameWithPage(username, (pageCurrent-1)*pageSize, pageSize));
            return pageObject;
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("未知错误");
        }
    }
}
