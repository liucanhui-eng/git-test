package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//专辑
public class Album implements Serializable {
    private String id;        //id
    private String title;     //专辑标题
    private String picPath;   //专题图片路径
    private Double score;     //评分
    private String author;     //作者
    private String announcer; //播音员
    private Integer number;   //集数
    private String ms;     //描述
    private String status;    //状态
    private Date uploadDate;        //上传日期
    private List<Audio> children; //专辑中的音频

    public Album(String id){
        this.id=id;
    }

    public Album(String id, String title, String picPath, Double score, String author, String announcer, Integer number, String ms, String status, Date uploadDate, List<Audio> children) {
        this.id = id;
        this.title = title;
        this.picPath = picPath;
        this.score = score;
        this.author = author;
        this.announcer = announcer;
        this.number = number;
        this.ms = ms;
        this.status = status;
        this.uploadDate = uploadDate;
        this.children = children;
    }

    public static Album setParam( String title, String picPath,  String author, String announcer,  String ms) {

        Album album = new Album();
        String id= UUID.randomUUID().toString().replace("-","");
        album.setId(id);
        album.setNumber(0);
        album.setScore(0.0);
        album.setUploadDate(new Date());
        album.setTitle(title);
        album.setPicPath(picPath);
        album.setAuthor(author);
        album.setAnnouncer(announcer);
        album.setMs(ms);
        album.setStatus("yes");
        return album;
    }








    public Album() {
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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public List<Audio> getChildren() {
        return children;
    }

    public void setChildren(List<Audio> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", picPath='" + picPath + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", announcer='" + announcer + '\'' +
                ", number=" + number +
                ", ms='" + ms + '\'' +
                ", status='" + status + '\'' +
                ", uploadDate=" + uploadDate +
                ", children=" + children +
                '}';
    }
}
