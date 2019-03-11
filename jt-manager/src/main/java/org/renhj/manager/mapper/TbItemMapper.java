package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TbItemMapper extends Mapper<TbItem> {
    int selectTotal();

    List<?> selectItemWithPage(@Param("start") int i, @Param("size") Integer pageSize);
}