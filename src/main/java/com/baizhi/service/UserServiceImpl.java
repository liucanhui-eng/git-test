package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.MapDate;
import com.baizhi.entity.TableDate;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public TableDate queryByDate() {
        TableDate tableDate = new TableDate();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = null;
        Date endDate1 = null;
        try {
            for (int i = 2; i <= 6; i++) {
                startDate1 = format.parse("2018-" + i + "-1");
                endDate1 = format.parse("2018-" + i + "-30");
                int count = dao.queryByDate(startDate1, endDate1);
                tableDate.getMonth().add(i + "月");
                tableDate.getCount().add(count);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tableDate;
    }

    @Override
    public MapDate queryByAreaAndSex() {
        MapDate mapDate = new MapDate();
        mapDate.setBoy(dao.queryByAreaAndSex("1"));
        mapDate.setGirl(dao.queryByAreaAndSex("0"));
        return mapDate;
    }

    @Override
    public List<User> queryUserByPage(String page, String rows) {
        Integer page1 = Integer.parseInt(page);
        Integer rows1 = Integer.parseInt(rows);
        return dao.queryUserByPage((page1 - 1) * rows1, rows1);
    }

    @Override
    public int queryUserCount() {
        return dao.queryUserCount();
    }

    @Override
    public Object queryByTel(String tel, String password) {
        User user = dao.queryByTel(tel);
        HashMap<String, String> map = new HashMap<>();
        if (user == null) {
            map.put("error", "-200");
            map.put("errmsg", "用户不存在");
            return map;
        }
        if (!user.getPassword().equals(password)) {
            map.put("error", "-200");
            map.put("errmsg", "密码错误");
            return map;
        }
        return user;
    }

    @Override
    public Map<String, String> register(String phone, String password) {
        User user = User.setParam(phone, password, null, null, null, null, null, null, null);
        HashMap<String, String> map = new HashMap<>();
        User user1 = dao.queryByTel(phone);
        if (user1 == null) {
            dao.insert(user);
            map.put("password", password);
            map.put("uid", user.getId());
            map.put("phone", phone);
        } else {
            map.put("errno", "-200");
            map.put("error_msg", "该手机号已经存在");
        }
        return map;
    }

    @Override
    public Object motify(User user) {
        try {
            dao.updateuser(user);
           // throw new Exception("终于报错了");

        } catch (Exception e) {
            e.printStackTrace();
            HashMap<String, String> map = new HashMap<>();
            map.put("error","-200");
            map.put("error_msg","修改失败:"+e.getMessage());
            return map;
        }
        return user;
    }

    @Override
    public List<User> randomUser(String uid) {
        return dao.RandomUser(uid);
    }
}
