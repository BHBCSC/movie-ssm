package com.csc.movie.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Movie implements Serializable {
    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", score=" + score +
                //", celebrityList=" + celebrityList +
                '}';
    }

    private int movieId;
    private String name;
    private float score;
    private List<Watched> watchedList;
    private List<Celebrity> celebrityList;

    public Movie() {
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

    public List<Celebrity> getCelebrityList() {
        return celebrityList;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setWatchedList(List<Watched> watchedList) {
        this.watchedList = watchedList;
    }

    public void setCelebrityList(List<Celebrity> celebrityList) {
        this.celebrityList = celebrityList;
    }
}
