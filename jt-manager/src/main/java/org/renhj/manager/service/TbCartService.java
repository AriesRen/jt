package org.renhj.manager.service;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.pojo.domain.TbCart;
import org.renhj.manager.pojo.domain.TbOrder;
import org.renhj.manager.pojo.domain.TbUser;

import java.util.List;

public interface TbCartService {
    Page findCartsWithPage(Integer pageCurrent, Integer pageSize);

    int saveCart(TbCart cart);

    int deleteCartById(String id);

    int updateCart(TbCart cart);

    TbCart findCartById(String id);
}
