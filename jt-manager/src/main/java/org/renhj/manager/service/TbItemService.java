package org.renhj.manager.service;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.pojo.domain.TbItem;

public interface TbItemService {
    Page findItemWithPage(Integer pageCurrent, Integer pageSize);

    int saveItem(TbItem item);

    int deleteItemById(Long id);

    int updateItem(TbItem item);

    TbItem findItemById(Long id);

    int patchItem(Long id, TbItem item);
}
