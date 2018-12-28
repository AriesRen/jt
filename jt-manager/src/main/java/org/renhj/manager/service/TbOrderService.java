package org.renhj.manager.service;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.pojo.domain.TbOrder;
import org.renhj.manager.pojo.domain.TbUser;

import java.util.List;

public interface TbOrderService {
    Page findOrdersWithPage(Integer pageCurrent, Integer pageSize);

    int saveOrder(TbOrder order);

    int deleteOrderById(String id);

    int updateOrder(TbOrder order);

    TbOrder findOrderById(String id);
}
