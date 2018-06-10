package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    void insert();

    //今天的
    void update(User user);
    //
    void delete(String id);
    //
    List<User> queryAll();

}
