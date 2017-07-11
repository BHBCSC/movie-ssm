package com.csc.movie.dao;

import com.csc.movie.BaseTest;
import com.csc.movie.entity.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class MovieDAOTest extends BaseTest{
    @Autowired
    private MovieDAO movieDAO;

    @Test
    public void queryById() throws Exception {
        int id =1;
        System.out.println(movieDAO.queryById(id));
    }

    @Test
    public void queryAll() throws Exception {
        int count = movieDAO.count();
        List<Movie> movies = movieDAO.queryAll(0,count);
        for(Movie m:movies){
            System.out.println(m);
        }
    }

}