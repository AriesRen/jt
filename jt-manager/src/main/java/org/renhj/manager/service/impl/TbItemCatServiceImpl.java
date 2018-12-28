package org.renhj.manager.service.impl;

import org.renhj.manager.mapper.TbItemCatMapper;
import org.renhj.manager.pojo.domain.TbItemCat;
import org.renhj.manager.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<?> findItemCatByParentId(Long id) {
        TbItemCat itemCat = new TbItemCat();
        itemCat.setParentId(id);
        return itemCatMapper.select(itemCat);
    }

    @Override
    public TbItemCat findItemCatById(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateItemCat(Long id, TbItemCat itemCat) {
        return 0;
    }

    @Override
    public int deleteItemCat(Long id) {
        return 0;
    }
}
