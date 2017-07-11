package com.csc.movie.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Movie {
    private int id;
    private String name;
    private float score;
    private List<Watched> watchedList;

    public Movie(){}


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }


}
