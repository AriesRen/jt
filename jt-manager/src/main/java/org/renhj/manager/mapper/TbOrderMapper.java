package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbOrder;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TbOrderMapper extends Mapper<TbOrder> {
    Integer selectTotal();

    List<?> selectOrderWithPage(@Param("start") Integer start, @Param("size") Integer size);
}