package com.baizhi.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Audio implements Serializable {
    private String id;     //音频id
    private String title;  //音频名
    private String size;   //音频大小 多少kb
    private String downPath;//下载路径
    private String albumId; //专辑id
    private String status="yes";  //状态
    private String duration; //音频时长
    private Date uploadDate=new Date();       //上传的时间


    public static Audio SetParam(String title,String size,String downPath,String albumId,String duration){
        Audio audio=new Audio();
        String id= UUID.randomUUID().toString().replace("-","");
        audio.setId(id);
        audio.setTitle(title);
        audio.setSize(size);
        audio.setDownPath(downPath);
        audio.setAlbumId(albumId);
        audio.setDuration(duration);
        return audio;
    }

    public Audio(String id, String title, String size, String downPath, String albumId, String status, String duration, Date uploadDate) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.downPath = downPath;
        this.albumId = albumId;
        this.status = status;
        this.duration = duration;
        this.uploadDate = uploadDate;
    }

    public Audio() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", downPath='" + downPath + '\'' +
                ", albumId='" + albumId + '\'' +
                ", status='" + status + '\'' +
                ", duration='" + duration + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
