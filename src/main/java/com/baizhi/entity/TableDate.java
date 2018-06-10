package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class TableDate {
    List<String> month=new ArrayList<>();
    List<Integer> count=new ArrayList<>();

    public TableDate(List<String> month, List<Integer> count) {
        this.month = month;
        this.count = count;
    }

    public TableDate() {
    }

    public List<Integer> getCount() {
        return count;
    }

    public void setCount(List<Integer> count) {
        this.count = count;
    }

    public List<String> getMonth() {
        return month;
    }

    public void setMonth(List<String> month) {
        this.month = month;
    }



    @Override
    public String toString() {
        return "TableDate{" +
                "month=" + month +
                ", count=" + count +
                '}';
    }
}
