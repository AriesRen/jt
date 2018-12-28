package org.renhj.manager.service.impl;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbOrderMapper;
import org.renhj.manager.pojo.domain.TbOrder;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {
    @Autowired
    private TbOrderMapper orderMapper;

    public Page findOrdersWithPage(Integer pageCurrent, Integer pageSize) {
        int total = orderMapper.selectTotal();
        List<?> list = orderMapper.selectOrderWithPage((pageCurrent-1)*pageSize, pageSize);
        return new Page(total,pageSize, pageCurrent, (total-1)/pageSize +1, list);
    }

    public int saveOrder(TbOrder order) {
        return orderMapper.insert(order);
    }

    public int deleteOrderById(String id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    public int updateOrder(TbOrder order) {
        return orderMapper.updateByPrimaryKey(order);
    }

    public TbOrder findOrderById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }
}
