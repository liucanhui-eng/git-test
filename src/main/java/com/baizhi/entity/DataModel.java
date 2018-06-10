package com.baizhi.entity;


import java.util.List;

public class DataModel {
    private List<SlideShow> header;
    private List<Album> album;

    @Override
    public String toString() {
        return "DataModel{" +
                "header=" + header +
                ", album=" + album +
                '}';
    }

    public List<SlideShow> getHeader() {
        return header;
    }

    public void setHeader(List<SlideShow> header) {
        this.header = header;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public DataModel() {

    }

    public DataModel(List<SlideShow> header, List<Album> album) {

        this.header = header;
        this.album = album;
    }
}
