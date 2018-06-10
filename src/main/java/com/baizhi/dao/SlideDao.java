package com.baizhi.dao;

import com.baizhi.entity.SlideShow;

import java.util.List;

public interface SlideDao {
    void insert(SlideShow slideShow);
    void delete(String id);
    void update(SlideShow slideShow);
    List<SlideShow> queryAll();
    //按时间排序，查询出最新的6张图片
    List<SlideShow> queryByDate();
}
