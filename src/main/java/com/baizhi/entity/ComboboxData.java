package com.baizhi.entity;

public class ComboboxData {
    private  String id;
    private  String text;

    public ComboboxData(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public ComboboxData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
