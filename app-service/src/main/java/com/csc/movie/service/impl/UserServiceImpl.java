//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.csc.movie.service.impl;

import com.csc.movie.dao.UserDAO;
import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
    }


    public User getMovieList(String username) {
        return userDAO.queryFetchMovie(username);
    }
}
