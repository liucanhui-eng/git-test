package com.baizhi.entity;

import java.util.Date;

public class DemoLog {
    private  Integer id;
    private  String admin;
    private  String operation;
    private  Date   date;
    private String result;

    public DemoLog( String admin, String operation, Date date, String result) {
        this.admin = admin;
        this.operation = operation;
        this.date = date;
        this.result = result;
    }

    public DemoLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "DemoLog{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", operation='" + operation + '\'' +
                ", date=" + date +
                ", result='" + result + '\'' +
                '}';
    }
}
