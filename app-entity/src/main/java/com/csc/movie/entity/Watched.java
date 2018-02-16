package com.csc.movie.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
public class Watched implements Serializable {
    private User user;
    private Movie movie;
    private int score;
    private String comment;

    public Watched() {
    }

    public Watched(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Watched{" +
                //"user=" + user.getId() +
                //"movie=" + movie +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
