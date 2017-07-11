package com.csc.movie.dao;

import com.csc.movie.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public class UserDAOTest extends BaseTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void verify(){
        System.out.println(userDAO.query("fuck","you"));
    }

    @Test
    public void testAdd(){
        userDAO.add("fuck","me");
    }

    @Test
    public void testQueryFetchMovie(){
        System.out.println(userDAO.queryFetchMovie(2));
    }
}
