package org.renhj.manager.service.impl;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbItemMapper;
import org.renhj.manager.pojo.domain.TbItem;
import org.renhj.manager.pojo.exception.ServiceException;
import org.renhj.manager.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public Page findItemWithPage(Integer pageCurrent, Integer pageSize) {
        int total = itemMapper.selectTotal();
        List<?> list = itemMapper.selectItemWithPage((pageCurrent-1)*pageSize, pageSize);
        return new Page(total, pageSize, pageCurrent, (total-1)/pageSize+1, list);
    }

    @Override
    public int saveItem(TbItem item) {
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        return itemMapper.insert(item);
    }

    @Override
    public int deleteItemById(Long id) {
        TbItem item = itemMapper.selectByPrimaryKey(id);
        if (item == null){
            throw new ServiceException("Not Found this item!");
        }
        return itemMapper.delete(item);
    }

    @Override
    public int updateItem(TbItem item) {
        if (itemMapper.selectOne(item) == null) {
            throw new ServiceException("Not Found this item!");
        }
        return itemMapper.updateByPrimaryKey(item);
    }

    @Override
    public TbItem findItemById(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int patchItem(Long id, TbItem item) {
        if (itemMapper.selectByPrimaryKey(id) == null){
            throw new ServiceException("Not Found This Item!");
        }
        item.setId(id);
        item.setUpdated(new Date());
        return itemMapper.updateByPrimaryKeySelective(item);
    }
}
