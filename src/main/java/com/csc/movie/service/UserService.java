package com.csc.movie.service;

import com.csc.movie.entity.User;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public interface UserService {
    User login(String username,String password);

    boolean register(String username ,String password);

    public User queryFetchMovie(int id);
}
