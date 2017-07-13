package com.csc.movie.service;

import com.csc.movie.entity.Movie;
import com.csc.movie.entity.User;
import com.csc.movie.entity.Watched;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public interface MovieService {
    Movie getMovieById(int movieId);

    Watched movieWathced(int userId, int movieId);

    void doMovieWatched(int userId, int movieId, Watched watched);

    boolean doWatchedDelete(int userId, int movieId);
}
