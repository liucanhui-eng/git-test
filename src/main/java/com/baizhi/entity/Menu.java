package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;
    private String title;
    private String iconCls;
    private String parent_id;
    private String url;
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public String getParent_id() {
        return parent_id;
    }

    public String getUrl() {
        return url;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(String id, String title, String iconCls, String parent_id, String url, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.parent_id = parent_id;
        this.url = url;
        this.children = children;
    }

    public Menu() {}

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
