package com.csc.movie.dao;

import com.csc.movie.BaseTest;
import com.csc.movie.entity.Actor;
import com.csc.movie.entity.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class ActorDAOTest extends BaseTest{
    @Autowired
    private ActorDAO actorDAO;

    @Test
    public void queryById() throws Exception {
        int id =1;
        System.out.println(actorDAO.queryById(id));
    }

    @Test
    public void queryByMovie() throws Exception {
        int id =1;
        System.out.println(actorDAO.queryByMovie(id));
    }
}