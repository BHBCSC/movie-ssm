package com.csc.movie.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Movie {
    private int movieId;
    private String name;
    private float score;
    private List<Watched> watchedList;
    private List<Celebrity> celebrityList;

    public Movie(){}


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }


}
