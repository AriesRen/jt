package org.renhj.manager.service;

import org.renhj.manager.pojo.domain.TbItemCat;

import java.util.List;

public interface TbItemCatService {
    List<?> findItemCatByParentId(Long id);

    TbItemCat findItemCatById(Long id);

    int updateItemCat(Long id, TbItemCat itemCat);

    int deleteItemCat(Long id);
}
