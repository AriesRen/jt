package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbCart;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TbCartMapper extends Mapper<TbCart> {
    int selectTotal();

    List<?> selectCartWithPage(@Param("pageCurrent") int i, @Param("pageSize") Integer pageSize);
}