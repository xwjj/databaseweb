package com.db.pojo;

/**
 * @Description: 用于axios传输数据
 * @Author: xw
 * @Date: 2022/12/9 22:30
 */
public class cartUser1 {
    String img;
    String name;
    char quality;
    int price;
    int number;
    String using;

    public cartUser1() {
    }

    public cartUser1(String img, String name, char quality, int price, int number, String using) {
        this.img = img;
        this.name = name;
        this.quality = quality;
        this.price = price;
        this.number = number;
        this.using = using;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getQuality() {
        return quality;
    }

    public void setQuality(char quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
    }

    @Override
    public String toString() {
        return "cartUser1{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", quality=" + quality +
                ", price=" + price +
                ", number=" + number +
                ", using='" + using + '\'' +
                '}';
    }
}
