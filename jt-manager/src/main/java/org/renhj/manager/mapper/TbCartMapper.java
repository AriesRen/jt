package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbCart;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TbCartMapper extends Mapper<TbCart> {
    int selectTotal();

    List<?> selectCartWithPage(@Param("start")Integer start, @Param("size")Integer size);
}