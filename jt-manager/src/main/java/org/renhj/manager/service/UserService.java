package org.renhj.manager.service;

import org.renhj.manager.pojo.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);

    User findUserByUsername(String username);

    List<User> findAll();
}
