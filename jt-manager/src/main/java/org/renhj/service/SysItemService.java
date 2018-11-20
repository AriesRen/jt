package org.renhj.service;

import org.renhj.common.PageObject;
import org.renhj.entity.SysItem;

public interface SysItemService {
    PageObject<SysItem> findItemByTitleWithPage(String title, Integer pageCurrent,Integer pageSize);

    int saveItem(SysItem item);

    int deleteItem(Long id);

    SysItem findItemById(Long id);

    SysItem updateItem(SysItem item);
}
