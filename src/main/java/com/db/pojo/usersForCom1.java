package com.db.pojo;

/**
 * @Description: 总公司展示用户用
 * @Author: xw
 * @Date: 2022/12/23 17:45
 */
public class usersForCom1 {
    String username;
    String password;
    String ip;
    Integer phone;

    public usersForCom1() {
    }

    public usersForCom1(String username, String password, String ip, Integer phone) {
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.phone = phone;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "usersForCom1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", phone=" + phone +
                '}';
    }
}
