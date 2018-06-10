package com.baizhi.entity;

import com.baizhi.annotation.NameAnnotation;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class User {
    @NameAnnotation(name="编号")
    private String id;
    @NameAnnotation(name="手机")
    private String tel;
    @NameAnnotation(name="密码")
    private String password;
    @NameAnnotation(name="盐")
    private String salt;   //盐
    @NameAnnotation(name="法名")
    private String dharmaName; //法名
    @NameAnnotation(name="姓名")
    private String name;       //名字
    @NameAnnotation(name="性别")
    private String sex;
    @NameAnnotation(name="省份")
    private String province;  //省份
    @NameAnnotation(name="城市")
    private String city;
    @NameAnnotation(name="签名")
    private String sign;      //个人签名
    @NameAnnotation(name="头像路径")
    private String headPic;   //头像路径
    @NameAnnotation(name="状态")
    private String status="yes";
    @NameAnnotation(name="注册日期")
    private Date date=new Date();
    public static User setParam(String tel,String password,String dharmaName,
                                String name,String sex,String province,String city,String sign,String headPic){
        User user = new User();
        String id = UUID.randomUUID().toString().replace("-", "");
        String salt="";
        char[] key ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i=0;i<4;i++){
            salt+=key[new Random().nextInt(key.length)];
        }

        String md5 = DigestUtils.md5Hex(password+salt);
        user.setId  (id);
        user.setTel(tel);
        user.setPassword(md5);
        user.setSalt(salt);
        user.setDharmaName(dharmaName);
        user.setName(name);
        user.setSex(sex);
        user.setProvince(province);
        user.setCity(city);
        user.setSign(sign);
        user.setHeadPic(headPic);
        return user;
    }

    public User(String id, String tel, String password, String salt, String dharmaName, String name, String sex, String province, String city, String sign, String headPic, String status, Date date) {
        this.id = id;
        this.tel = tel;
        this.password = password;
        this.salt = salt;
        this.dharmaName = dharmaName;
        this.name = name;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.headPic = headPic;
        this.status = status;
        this.date = date;
    }

    public User() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", headPic='" + headPic + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
