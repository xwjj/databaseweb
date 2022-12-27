package com.db.pojo;

import java.util.Date;

/**
 * @Description: 用作进货用
 * @Author: xw
 * @Date: 2022/12/18 11:03
 */
public class intoFoodBy1 {
    String name;
    String quality;
    Double inprice;
    Double outprice;
    Double number;
    String date;
    String username;

    @Override
    public String toString() {
        return "intoFoodBy1{" +
                "name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", inprice=" + inprice +
                ", outprice=" + outprice +
                ", number=" + number +
                ", date=" + date +
                ", username='" + username + '\'' +
                '}';
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

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public intoFoodBy1(String name, String quality, Double inprice, Double outprice, Double number, String date, String username) {
        this.name = name;
        this.quality = quality;
        this.inprice = inprice;
        this.outprice = outprice;
        this.number = number;
        this.date = date;
        this.username = username;
    }

    public intoFoodBy1() {
    }
}
