package com.baizhi.dao;

import com.baizhi.entity.MapDate;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserDao {
    void insert(User user);
    void update(@Param(value = "tel") String tel, @Param(value = "status") String status);
    //根据手机号查询用户
    User queryByTel(String tel);

    //统计最近注册人数
    int queryByDate(@Param(value = "startDate") Date startDate, @Param(value = "endDate") Date endDate);

    //统计各地区各性别人数
    List<UserMap> queryByAreaAndSex(String sex);

    //按注册时间分页查询用户
    List<User> queryUserByPage(@Param(value = "offset") Integer offset, @Param(value = "pageSize") Integer pageSize);
    //查询总人数
    int queryUserCount();
    //修改用户信息
    void updateuser(User user);
    //精钢道友
    List<User> RandomUser(String id);



}
