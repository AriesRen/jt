package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbItem;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TbItemMapper extends Mapper<TbItem> {
    Integer selectTotal();

    List<?> selectItemWithPage(@Param("start") Integer start, @Param("size") Integer size);
}