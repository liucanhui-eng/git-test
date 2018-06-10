package com.baizhi.entity;

public class UserMap {
    private Integer value ;//人数
    private String name;//省份

    public UserMap(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public UserMap() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserMap{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
