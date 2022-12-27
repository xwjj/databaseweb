package com.db.pojo;

/**
 * @Description: 新商铺凭此注册用
 * @Author: xw
 * @Date: 2022/12/19 15:36
 */
public class newKeeper1 {
    String username;
    String password;
    String ip;

    public newKeeper1() {
    }

    public newKeeper1(String username, String password, String ip) {
        this.username = username;
        this.password = password;
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "newKeeper1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
