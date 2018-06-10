package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public class SlideShow {
    private String id;
    private String title;
    private String imagePath;
    private String ms;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" ,timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss" )
    private Date date;
    private String tail;

    public SlideShow(String id, String title, String imagePath, String ms, String status, Date date, String tail) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.ms = ms;
        this.status = status;
        this.date = date;
        this.tail = tail;
    }

    public SlideShow setParam( String title, String imagePath, String ms,   String tail) {
        SlideShow s = new SlideShow();
        s.id = UUID.randomUUID().toString().replace("-","");
        s.title = title;
        s.imagePath = imagePath;
        s.ms = ms;
        s.status = "yes";
        s.date = new Date();
        s.tail = tail;
        return s;
    }

    public SlideShow() {
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "SlideShow{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ms='" + ms + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", tail='" + tail + '\'' +
                '}';
    }
}
