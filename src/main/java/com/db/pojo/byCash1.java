package com.db.pojo;

/**
 * @Description: 收银台商品信息
 * @Author: xw
 * @Date: 2022/12/16 17:19
 */
public class byCash1 {
    String img;
    String name;
    String quality;
    Double outprice;

    public byCash1() {
    }

    public byCash1(String img, String name, String quality, Double outprice) {
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.outprice = outprice;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "byCash1{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", ourprice=" + outprice +
                '}';
    }

    public Double getOurprice() {
        return outprice;
    }

    public void setOurprice(Double outprice) {
        this.outprice = outprice;
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

}
