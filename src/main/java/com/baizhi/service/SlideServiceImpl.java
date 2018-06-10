package com.baizhi.service;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.dao.SlideDao;
import com.baizhi.entity.SlideShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideServiceImpl implements SlideService {
    @Autowired
    SlideDao dao;
    @Override
    public List<SlideShow> showAll() {
        return dao.queryAll();
    }

    @Override
    @LogAnnotation(name ="更新轮播图" )
    public void update(SlideShow slideShow) {

        dao.update(slideShow);

    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void add(SlideShow slideShow) {
        dao.insert(slideShow);
    }
}
