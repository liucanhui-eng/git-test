package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    void insert(Album audio);
    void updateStatus(@Param(value = "id") String id, @Param(value = "status") String status);
    void updateNumber(@Param(value = "id") String id, @Param(value = "number") String number);

    List<Album> queryAll();

    List<Album> queryByDate();
    Album queryById(String id);
}
