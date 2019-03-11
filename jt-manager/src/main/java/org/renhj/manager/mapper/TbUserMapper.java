package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TbUserMapper extends Mapper<TbUser> {
    Integer selectTotalByUsername(@Param("username") String username);

    List<?> selectUsersByUsernameWithPage(@Param("username") String username, @Param("start") int i, @Param("size") Integer pageSize);

    TbUser selectOneByUsername(@Param("username") String username);

    TbUser selectOneByEmail(String email);
}