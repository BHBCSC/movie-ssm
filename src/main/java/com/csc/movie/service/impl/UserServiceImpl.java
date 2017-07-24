//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.csc.movie.service.impl;

import com.csc.movie.dao.UserDAO;
import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
    }

    public User checkUserName(String username) {
        return userDAO.queryByUserName(username);
    }

    public User login(String username, String password) {
        return userDAO.query(username, password);
    }

    public boolean register(String username, String password) {
        try {
            userDAO.add(username, password);
            return true;
        } catch (DuplicateKeyException var4) {
            return false;
        }
    }

    public User getMovieList(int id) {
        return userDAO.queryFetchMovie(id);
    }
}
