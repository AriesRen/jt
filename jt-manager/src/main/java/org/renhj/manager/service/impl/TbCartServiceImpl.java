package org.renhj.manager.service.impl;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbCartMapper;
import org.renhj.manager.pojo.domain.TbCart;
import org.renhj.manager.service.TbCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbCartServiceImpl implements TbCartService {
    @Autowired
    private TbCartMapper cartMapper;

    @Override
    public Page findCartsWithPage(Integer pageCurrent, Integer pageSize) {
        int total = cartMapper.selectTotal();
        List<?> list = cartMapper.selectCartWithPage((pageCurrent-1)*pageSize, pageSize);
        return new Page(total, pageSize, pageCurrent, (total-1)/pageSize+1, list);
    }

    @Override
    public int saveCart(TbCart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public int deleteCartById(String id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCart(TbCart cart) {
        return cartMapper.updateByPrimaryKey(cart);
    }

    @Override
    public TbCart findCartById(String id) {
        return cartMapper.selectByPrimaryKey(id);
    }
}
