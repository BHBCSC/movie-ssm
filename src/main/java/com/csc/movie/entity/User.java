package com.csc.movie.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private List<Watched> watchedList;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Watched> getWatchedList() {
        return watchedList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", watchedList=" + watchedList +
                '}';
    }
}
