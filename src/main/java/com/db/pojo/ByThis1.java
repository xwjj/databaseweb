package com.db.pojo;

/**
 * @Description: 相当于订单项的主键，用于查询订单
 * @Author: xw
 * @Date: 2022/12/12 20:10
 */
public class ByThis1 {
    String username;
    String name;
    String quality;

    public ByThis1() {
    }

    public ByThis1(String username, String name, String quality) {
        this.username = username;
        this.name = name;
        this.quality = quality;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    @Override
    public String toString() {
        return "deleteByThis{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
