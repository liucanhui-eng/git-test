package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin queryByName(String name);
    void updateKey(@Param(value = "name") String name, @Param(value = "password") String password);
}
