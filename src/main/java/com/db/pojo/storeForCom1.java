package com.db.pojo;

/**
 * @Description: 店铺信息总公司名
 * @Author: xw
 * @Date: 2022/12/23 17:30
 */
public class storeForCom1 {
    Integer id;
    String ip;
    String username;

    public storeForCom1() {
    }

    public storeForCom1(Integer id, String ip, String username) {
        this.id = id;
        this.ip = ip;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "storeForCom{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
