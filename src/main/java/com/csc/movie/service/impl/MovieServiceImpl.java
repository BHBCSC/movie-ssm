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
        return this.movieDAO.queryById(id);
    }

    public Watched movieWathced(int userId, int movieId) {
        return this.watchedDAO.queryWatched(userId, movieId);
    }

    public void doMovieWatched(int userId, int movieId, Watched watched) {
        Watched gotWatched = this.movieWathced(userId, movieId);
        if (gotWatched != null) {
            this.watchedDAO.updateWatched(userId, movieId, watched.getScore(), watched.getComment());
        } else {
            this.watchedDAO.insertWatched(userId, movieId, watched.getScore(), watched.getComment());
        }

    }

    public boolean doWatchedDelete(int userId, int movieId) {
        Watched watched = this.movieWathced(userId, movieId);
        return watched != null && this.watchedDAO.deleteWatched(userId, movieId) > 0;
    }
}
