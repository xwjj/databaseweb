package com.db.pojo;

import java.util.Date;

/**
 * @Description: 商店库存周转信息用
 * @Author: xw
 * @Date: 2022/12/13 17:09
 */
public class keeperByThis {
    /*图片名*/
    String img;
    /*商品名*/
    String name;
    /*商品等级*/
    String quality;
    /*进价*/
    Double inprice;
    /*售价*/
    Double outprice;
    /*库存*/
    Double number;
    /*生产日期*/
    Date start;
    /*保质日期*/
    Integer day;
    /*转换为字符串类型的时间，格式为new SimpleDateFormat("MM dd,yyyy HH:mm:ss");*/
    String tool;

    @Override
    public String toString() {
        return "keeperByThis{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", inprice=" + inprice +
                ", outprice=" + outprice +
                ", number=" + number +
                ", start=" + start +
                ", day=" + day +
                ", tool='" + tool + '\'' +
                '}';
    }

    public keeperByThis(String img, String name, String quality, Double inprice, Double outprice, Double number, Date start, Integer day, String tool) {
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.inprice = inprice;
        this.outprice = outprice;
        this.number = number;
        this.start = start;
        this.day = day;
        this.tool = tool;
    }

    public keeperByThis() {
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public keeperByThis(String img, String name, String quality, Double inprice, Double outprice, Double number, Date start, Integer day) {
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.inprice = inprice;
        this.outprice = outprice;
        this.number = number;
        this.start = start;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

}
