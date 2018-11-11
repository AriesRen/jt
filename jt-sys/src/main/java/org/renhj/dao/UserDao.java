package org.renhj.dao;

import org.renhj.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findUsers();
}
