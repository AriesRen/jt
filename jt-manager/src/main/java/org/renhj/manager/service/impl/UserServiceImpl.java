package org.renhj.manager.service.impl;

import org.renhj.manager.mapper.UserMapper;
import org.renhj.manager.pojo.domain.User;
import org.renhj.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
