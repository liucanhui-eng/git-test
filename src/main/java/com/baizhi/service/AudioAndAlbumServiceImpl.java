package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.AudioDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Audio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioAndAlbumServiceImpl implements AudioAndAlbumService {
    @Autowired
    AudioDao audioDao;
    @Autowired
    AlbumDao albumDao;

    @Override
    public void addAlbum(Album album) {//添加专辑
        albumDao.insert(album);
    }

    @Override
    public void updateAlbum(Album album) {//修改专辑
        albumDao.updateStatus(album.getId(),album.getStatus());
    }

    @Override
    public List<Album> showAll() {//查询专辑
        return albumDao.queryAll();
    }

    @Override
    public void addAudio(Audio audio) {//添加音频

        audioDao.insert(audio);
    }

    @Override
    public void updateAudio(Audio audio) {//修改音频
        audioDao.update(audio.getId(),audio.getStatus());

    }

    @Override
    public Audio selectUploadPath(String id) {

        return audioDao.queryAuduiById(id);
    }
}
