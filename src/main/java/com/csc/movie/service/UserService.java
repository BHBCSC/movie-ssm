
package com.csc.movie.service;

import com.csc.movie.entity.User;

public interface UserService {
    User login(String username, String password);

    boolean register(String username, String password);

    User getMovieList(int movieId);
}
