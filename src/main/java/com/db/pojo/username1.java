package com.db.pojo;

/**
 * @Description: axios传名字用
 * @Author: xw
 * @Date: 2022/12/23 21:33
 */
public class username1 {
    String username;

    public username1() {
    }

    public username1(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "username1{" +
                "username='" + username + '\'' +
                '}';
    }
}
