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

    @Override
    public List<Movie> getMovies(int offset, int limit) {
        return movieDAO.queryAll(offset, limit);
    }

    public Movie getMovieById(int id) {
        int count = movieDAO.count();
        return movieDAO.queryById(id, count);
    }

    @Override
    public List<Movie> getMoviesByName(String name, int offset, int limit) {
        return movieDAO.queryLikeName(name, offset, limit);
    }

    @Override
    public int getMoviePages(int limit) {
        int count = movieDAO.count();

        int pages = (count % limit == 0) ? count / limit : count / limit + 1;

        return pages;
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

    @Override
    public int getMoviesByNameCount(String name) {
        return movieDAO.queryLikeNameCount(name);
    }

    @Override
    public void addMovie(Movie movie) {
        movieDAO.add(movie.getName());
    }

    @Override
    public void deleteMovie(int id) {
        movieDAO.delete(id);
    }

    @Override
    public void modifyMovie(Movie movie) {
        movieDAO.modify(movie.getMovieId(), movie.getName());
    }
}
