package org.renhj.service.impl;

import org.renhj.common.PageObject;
import org.renhj.dao.SysItemDao;
import org.renhj.entity.SysItem;
import org.renhj.service.SysItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysItemServiceImpl implements SysItemService {
    @Autowired
    private SysItemDao sysItemDao;

    @Override
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
    public int saveItem(SysItem item) {
        return sysItemDao.saveItem(item);
    }

    @Override
    public int deleteItem(Integer id) {
        return sysItemDao.deleteTitleById(id);
    }
}
