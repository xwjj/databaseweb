package com.db.pojo;

/**
 * @Description: 收银用
 * @Author: xw
 * @Date: 2022/12/16 19:03
 */
public class sortMoney1 {
    /*食物名*/
    String name;
    /*食品等级*/
    String quality;
    /*库存数量*/
    Double number;
    /*店主名*/
    String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "sortMoney1{" +
                "name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", number=" + number +
                ", username='" + username + '\'' +
                '}';
    }

    public sortMoney1(String name, String quality, Double number, String username) {
        this.name = name;
        this.quality = quality;
        this.number = number;
        this.username = username;
    }

    public sortMoney1() {
    }
}
