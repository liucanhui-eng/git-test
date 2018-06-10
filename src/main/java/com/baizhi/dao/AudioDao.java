package com.baizhi.dao;

import com.baizhi.entity.Audio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AudioDao {
    void insert(Audio audio);
    void update(@Param(value = "id") String id, @Param(value = "status") String status);
    Audio queryAuduiById(String id);
}
