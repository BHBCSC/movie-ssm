package com.csc.movie.service;

import com.csc.movie.entity.Movie;
import com.csc.movie.entity.User;
import com.csc.movie.entity.Watched;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public interface MovieService {
    List<Movie> getMovies(int offset, int limit);

    Movie getMovieById(int movieId);

    Movie getMovieByIdLimit(int id);

    List<Movie> getMoviesByName(String name, int offset, int limit);

    int getMoviePages(int limit);

    Watched movieWathced(int userId, int movieId);

    void doMovieWatched(int userId, int movieId, Watched watched);

    boolean doWatchedDelete(int userId, int movieId);

    void updateMovieScore(int movieId);

    int getMoviesByNameCount(String name);

    void addMovie(Movie movie);

    void deleteMovie(int id);

    void modifyMovie(Movie movie);
}
