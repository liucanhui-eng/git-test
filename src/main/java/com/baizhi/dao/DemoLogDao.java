package com.baizhi.dao;

import com.baizhi.entity.DemoLog;

import java.util.List;

public interface DemoLogDao {
    void insert(DemoLog demoLog);
    List<DemoLog> queryAll();
}
