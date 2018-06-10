package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Audio;

import java.util.List;

public interface AudioAndAlbumService {
    //添加专辑业务
    void addAlbum(Album album);

    //修改专辑业务
    void updateAlbum(Album album);

    //查询所有专辑业务
    List<Album> showAll();

    //添加音频业务
    void addAudio(Audio audio);
    //修改音频业务
    void updateAudio(Audio audio);

    //查询下载路径
    Audio selectUploadPath(String id);
}
