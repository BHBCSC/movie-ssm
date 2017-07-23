package com.csc.movie.service.impl;

import com.csc.movie.dao.MovieDAO;
import com.csc.movie.dao.WatchedDAO;
import com.csc.movie.entity.Movie;
import com.csc.movie.entity.Watched;
import com.csc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private WatchedDAO watchedDAO;

    public MovieServiceImpl() {
    }

    public Movie getMovieByIdLimit(int id) {
        int count = movieDAO.count();
        int limit;
        limit = (count <= 10) ? count : 10;
        return movieDAO.queryById(id, limit);
    }

    public Movie getMovieById(int id) {
        int count = movieDAO.count();
        return movieDAO.queryById(id, count);
    }

    //返回null表示没看过
    public Watched movieWathced(int userId, int movieId) {
        return watchedDAO.query(userId, movieId);
    }

    //看过就修改，没看过就增加
    public void doMovieWatched(int userId, int movieId, Watched watched) {
        Watched gotWatched = this.movieWathced(userId, movieId);
        if (gotWatched != null) {
            watchedDAO.update(userId, movieId, watched.getScore(), watched.getComment());
        } else {
            watchedDAO.insert(userId, movieId, watched.getScore(), watched.getComment());
        }

    }

    public boolean doWatchedDelete(int userId, int movieId) {
        Watched watched = movieWathced(userId, movieId);
        return watched != null && watchedDAO.delete(userId, movieId) > 0;
    }

    public void updateMovieScore(int movieId) {
        float score = 0;
        int size = 0;
        List<Watched> watchedList = watchedDAO.queryWatchedScoreFetchMovieId(movieId);
        if (watchedList != null && (size = watchedList.size()) > 0) {
            for (Watched w : watchedList) {
                score += w.getScore();
            }
        }
        score = score / size;
        score = ((float) Math.round(score * 100) / 100);
        movieDAO.update(movieId, score);
    }
}
