
package com.csc.movie.service;

import com.csc.movie.entity.User;

import java.util.Set;

public interface AccountService {
    User login(String username, String password);

    boolean register(String username, String password);

    public User getUser(String username);

    Set<String> getRoles(String username);

    int getId(String username);
}
