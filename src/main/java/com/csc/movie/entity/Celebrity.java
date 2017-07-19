package com.csc.movie.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Celebrity {
    private int id;
    private String name;
    private List<Movie> movieList;

    @Override
    public String toString() {
        return "Celebrity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}
