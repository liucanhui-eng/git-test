package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    void insert();

    //今天的
    void update(User user);
    //
    void delete(String id);
}
