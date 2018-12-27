package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbBook;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TbBookMapper extends Mapper<TbBook> {
    int selectTotal();

    List<?> selectBookWithPage(@Param("start")Integer start, @Param("size")Integer size);
}