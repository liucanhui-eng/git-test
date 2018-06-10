package com.baizhi.service;


import com.baizhi.entity.MapDate;
import com.baizhi.entity.TableDate;
import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    TableDate queryByDate();
    MapDate queryByAreaAndSex();
    List<User> queryUserByPage(String page, String rows);
    int queryUserCount();
    //根据手机号查询用户
    Object queryByTel(String tel, String password);
    //相互测
    Map<String,String> register(String phone, String password);
    //修改用户信息
    Object motify(User user);
    //精钢道友
    List<User> randomUser(String uid);
}
