package com.baizhi.entity;

import java.util.List;

public class MapDate {
    private List<UserMap> girl;
    private List<UserMap> boy;

    public MapDate(List<UserMap> girl, List<UserMap> boy) {
        this.girl = girl;
        this.boy = boy;
    }

    public MapDate() {
    }

    public List<UserMap> getGirl() {
        return girl;
    }

    public void setGirl(List<UserMap> girl) {
        this.girl = girl;
    }

    public List<UserMap> getBoy() {
        return boy;
    }

    public void setBoy(List<UserMap> boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "MapDate{" +
                "girl=" + girl +
                ", boy=" + boy +
                '}';
    }
}
