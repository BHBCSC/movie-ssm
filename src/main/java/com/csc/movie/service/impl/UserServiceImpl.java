package com.csc.movie.service.impl;

import com.csc.movie.dao.UserDAO;
import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        return userDAO.query(username,password);
    }

    @Override
    public boolean register(String username, String password) {
        try{
        userDAO.add(username, password);
        } catch (DuplicateKeyException e){
            return false;
        }
        return true;
    }

    public User queryFetchMovie(int id){
        return userDAO.queryFetchMovie(id);
    }
}
