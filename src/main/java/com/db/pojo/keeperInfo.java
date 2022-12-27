package com.db.pojo;

/**
 * @Description: 用来显示店主信息
 * @Author: xw
 * @Date: 2022/12/22 18:02
 */
public class keeperInfo {
    Integer id;
    String username;
    String password;
    String ip;

    public keeperInfo() {
    }

    public keeperInfo(Integer id, String username, String password, String ip) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "keeperInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
