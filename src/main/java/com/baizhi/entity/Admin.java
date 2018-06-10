package com.baizhi.entity;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String state;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Admin() {
    }

    public Admin(String id, String name, String password, String state) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
