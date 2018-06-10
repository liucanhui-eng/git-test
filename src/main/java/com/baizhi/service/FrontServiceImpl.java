package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.SlideDao;
import com.baizhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FrontServiceImpl implements  FrontService {
    @Autowired
    SlideDao slideDao;//轮播图
    @Autowired
    AlbumDao albumDao;//吉祥妙音
    @Override
    public DataModel firstPage() {
        List<SlideShow> slideShows = slideDao.queryByDate();
        List<Album> albums = albumDao.queryByDate();
        DataModel dataModel = new DataModel();
        dataModel.setAlbum(albums);
        dataModel.setHeader(slideShows);
        return dataModel;
    }

    @Override
    public WenData albumDetail(String id) {
        Album album = albumDao.queryById(id);
        List<Audio> list = album.getChildren();
        WenData data = new WenData();
        album.setChildren(null);
        data.setIntroduction(album);
        data.setLits(list);
        return data;
    }





}
