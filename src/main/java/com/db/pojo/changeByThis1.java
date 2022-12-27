package com.db.pojo;

/**
 * @Description: 用于修改库存生鲜的信息
 * @Author: xw
 * @Date: 2022/12/17 16:22
 */
public class changeByThis1 {
    String username;
    String name;
    String quality;
    Double inprice;
    Double outprice;
    Double number;

    public changeByThis1() {
    }

    @Override
    public String toString() {
        return "changeByThis1{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", inprice=" + inprice +
                ", outprice=" + outprice +
                ", number=" + number +
                '}';
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

    public changeByThis1(String username, String name, String quality, Double inprice, Double outprice, Double number) {
        this.username = username;
        this.name = name;
        this.quality = quality;
        this.inprice = inprice;
        this.outprice = outprice;
        this.number = number;
    }
}
