package com.baizhi.entity;

import java.util.List;

public class WenData {
    private Album introduction;
    private List<Audio> lits;

    public WenData(Album introduction, List<Audio> lits) {
        this.introduction = introduction;
        this.lits = lits;
    }

    public WenData() {
    }

    public Album getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Album introduction) {
        this.introduction = introduction;
    }

    public List<Audio> getLits() {
        return lits;
    }

    public void setLits(List<Audio> lits) {
        this.lits = lits;
    }

    @Override
    public String toString() {
        return "WenData{" +
                "introduction=" + introduction +
                ", lits=" + lits +
                '}';
    }
}
