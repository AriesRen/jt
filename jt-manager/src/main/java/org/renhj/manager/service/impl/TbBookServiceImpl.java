package org.renhj.manager.service.impl;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.mapper.TbBookMapper;
import org.renhj.manager.pojo.domain.TbBook;
import org.renhj.manager.pojo.domain.TbUser;
import org.renhj.manager.service.TbBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbBookServiceImpl implements TbBookService {
    @Autowired
    private TbBookMapper bookMapper;

    @Override
    public Page findBooksWithPage(Integer pageCurrent, Integer pageSize) {
        int total = bookMapper.selectTotal();
        List<?> list = bookMapper.selectBookWithPage((pageCurrent-1)*pageSize, pageSize);
        return new Page(total, pageSize, pageCurrent, (total-1)/pageSize+1, list);
    }

    @Override
    public int saveBook(TbBook book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteBookById(String id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBook(TbBook book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public TbBook findBookById(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }
}
