package com.csc.movie.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Celebrity implements Serializable {
    private int celebrityId;
    private String name;
    private int age;
    private List<Movie> movieList;

    public Celebrity() {
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "celebrityId=" + celebrityId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", movieList=" + movieList +
                '}';
    }

    public int getCelebrityId() {
        return celebrityId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
