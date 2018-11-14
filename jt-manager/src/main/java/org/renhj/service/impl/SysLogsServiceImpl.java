package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.renhj.exception.ServiceException;
import org.renhj.service.SysLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class SysLogsServiceImpl implements SysLogsService {

    @Autowired
    private SysLogsDao sysLogsDao;

    @Override
    public PageObject<SysLogs> findLogsByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        try {
            int rowCount = sysLogsDao.getRowCount(username);
            int pageCount = (rowCount -1)/pageSize + 1;

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

    @Override
    @Transactional(readOnly = false, timeout = 30, propagation = Propagation.REQUIRED)
    public Integer deleteLogsById(Integer id) {
        try {
            int row = sysLogsDao.deleteLogsById(id);
            if (row!=1){
                throw new ServiceException("删除失败");
            }
            return row;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
