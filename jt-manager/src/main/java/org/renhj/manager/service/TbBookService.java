package org.renhj.manager.service;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.pojo.domain.TbBook;
import org.renhj.manager.pojo.domain.TbOrder;
import org.renhj.manager.pojo.domain.TbUser;

import java.util.List;

public interface TbBookService {
    Page findBooksWithPage(Integer pageCurrent, Integer pageSize);

    int saveBook(TbBook book);

    int deleteBookById(String id);

    int updateBook(TbBook book);

    TbBook findBookById(String id);
}
