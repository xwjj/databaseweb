package com.db.pojo;

/**
 * @Description: 线上用户订单
 * @Author: xw
 * @Date: 2022/12/19 17:15
 */
public class onlineSub1 {
    /*线上用户名*/
    String username;
    /*商品图片*/
    String img;
    /*商品名*/
    String  name;
    /*商品等级*/
    String quality;
    /*售价*/
    Double outprice;
    /*数量*/
    Double number;
    /*总价*/
    Double all;

    public onlineSub1() {
    }

    @Override
    public String toString() {
        return "onlineSub1{" +
                "username='" + username + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", outprice=" + outprice +
                ", number=" + number +
                ", all=" + all +
                '}';
    }

    public Double getAll() {
        return all;
    }

    public void setAll(Double all) {
        this.all = all;
    }

    public onlineSub1(String username, String img, String name, String quality, Double outprice, Double number, Double all) {
        this.username = username;
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.outprice = outprice;
        this.number = number;
        this.all = all;
    }

    public onlineSub1(String username, String img, String name, String quality, Double outprice, Double number) {
        this.username = username;
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.outprice = outprice;
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

}
