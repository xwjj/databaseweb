package com.db.pojo;

/**
 * @Description: 完整的一条订单信息
 * @Author: xw
 * @Date: 2022/12/11 20:51
 */
public class completeCart1 {
    /*图片名*/
    String img;
    /*食物名*/
    String name ;
    /*质量等级*/
    String quality;
    /*产品单价*/
    Integer outprice;
    /*订单数量*/
    Integer number;
    /*总价*/
    Integer all;

    public completeCart1() {
    }

    public completeCart1(String img, String name, String quality, Integer outprice, Integer number, Integer all) {
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.outprice = outprice;
        this.number = number;
        this.all = all;
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

    public Integer getOutprice() {
        return outprice;
    }

    public void setOutprice(Integer outprice) {
        this.outprice = outprice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "completeCart1{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", outprice=" + outprice +
                ", number=" + number +
                ", all=" + all +
                '}';
    }
}
