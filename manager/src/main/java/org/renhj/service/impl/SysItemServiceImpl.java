package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysItemDao;
import org.renhj.entity.SysItem;
import org.renhj.exception.ServiceException;
import org.renhj.service.SysItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,timeout = 30)
public class SysItemServiceImpl implements SysItemService {
    @Autowired
    private SysItemDao sysItemDao;

    @Override
    @Transactional
    public PageObject<SysItem> findItemByTitleWithPage(String title, Integer pageCurrent, Integer pageSize) {

        // TODO: 判断total的是否为0
        int total = sysItemDao.getRowCount(title);

        List<SysItem> records =  sysItemDao.findItemByTitleWithPage((pageCurrent-1)*pageSize, pageSize, title);
        PageObject<SysItem> pageObject = new PageObject<>();
        pageObject.setPageSize(pageSize);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRecords(records);
        pageObject.setRow(total);
        pageObject.setPageCount((total - 1)/pageSize + 1);

        return pageObject;
    }

    @Override
    @Transactional(readOnly = false)
    public int saveItem(SysItem item) {
        return sysItemDao.saveItem(item);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteItem(Long id) {
        return sysItemDao.deleteTitleById(id);
    }

    @Override
    public SysItem findItemById(Long id) {
        return sysItemDao.findItemById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public SysItem updateItem(SysItem item) {
        if (sysItemDao.updateItem(item)>0){
            return sysItemDao.findItemById(item.getId());
        }
        throw new ServiceException("更新失败！");
    }
}
