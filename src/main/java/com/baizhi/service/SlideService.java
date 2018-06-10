package com.baizhi.service;

import com.baizhi.entity.SlideShow;

import java.util.List;

public interface SlideService {
    List<SlideShow> showAll();
    void update(SlideShow slideShow);
    void delete(String id);
    void add(SlideShow slideShow);



}
