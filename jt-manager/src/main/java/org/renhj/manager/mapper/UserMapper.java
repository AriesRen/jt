package org.renhj.manager.mapper;

import org.renhj.manager.pojo.domain.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<User> {
    User findUserById(Long id);
    User findUserByUsername(String username);
}