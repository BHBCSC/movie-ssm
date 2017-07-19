package com.csc.movie.service.impl;

import com.csc.movie.dao.MovieDAO;
import com.csc.movie.dao.WatchedDAO;
import com.csc.movie.entity.Movie;
import com.csc.movie.entity.Watched;
import com.csc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private WatchedDAO watchedDAO;

    public MovieServiceImpl() {
    }

    public Movie getMovieById(int id) {
        return movieDAO.queryById(id);
    }

    //
    public Watched movieWathced(int userId, int movieId) {
        return watchedDAO.queryWatched(userId, movieId);
    }

    //看过就修改，没看过就增加
    public void doMovieWatched(int userId, int movieId, Watched watched) {
        Watched gotWatched = this.movieWathced(userId, movieId);
        if (gotWatched != null) {
            watchedDAO.updateWatched(userId, movieId, watched.getScore(), watched.getComment());
        } else {
            watchedDAO.insertWatched(userId, movieId, watched.getScore(), watched.getComment());
        }

    }

    public boolean doWatchedDelete(int userId, int movieId) {
        Watched watched = movieWathced(userId, movieId);
        return watched != null && watchedDAO.deleteWatched(userId, movieId) > 0;
    }
}
