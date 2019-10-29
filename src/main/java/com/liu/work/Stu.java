package com.liu.work;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stu implements Serializable {
    private String name;
    private String sex;
    private Integer age;
    private Date date;
    private String phone;
    private String hobby;

    public Stu() {
    }

    public Stu(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Stu(String name, String sex, Integer age, Date date, String phone, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.date = date;
        this.phone = phone;
        this.hobby = hobby;
    }

    public String getBirStr() {
        //格式化
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(date);
        } else {
            return "";
        }
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
