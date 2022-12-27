package com.db.pojo;

/**
 * @Description: 搜索
 * @Author: xw
 * @Date: 2022/12/14 16:15
 */
public class search1 {
    /*食物名*/
    String name;
    /*用户名*/
    String username;

    public search1() {
    }

    public search1(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "search{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
