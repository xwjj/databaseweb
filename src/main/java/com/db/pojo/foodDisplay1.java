package com.db.pojo;

/**
 * @Description: 商品显示页面所要显示的信息
 * @Author: xw
 * @Date: 2022/12/14 16:34
 */
public class foodDisplay1 {
    /*图片名*/
    String img;
    /*食品名*/
    String name;
    /*价格*/
    Double outprice;
    /*品质*/
    String quality;
    /*数量*/
    Double number;

    public foodDisplay1() {
    }

    @Override
    public String toString() {
        return "foodDisplay1{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", outprice=" + outprice +
                ", quality='" + quality + '\'' +
                ", number=" + number +
                '}';
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

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
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

    public foodDisplay1(String img, String name, Double outprice, String quality, Double number) {
        this.img = img;
        this.name = name;
        this.outprice = outprice;
        this.quality = quality;
        this.number = number;
    }
}
