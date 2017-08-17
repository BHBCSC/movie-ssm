
package com.csc.movie.dao;

import com.csc.movie.entity.Watched;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WatchedDAO {
    Watched query(@Param("userId") int userId, @Param("movieId") int movieId);

    void insert(@Param("userId") int userId, @Param("movieId") int movieId, @Param("score") int score, @Param("comment") String comment);

    int update(@Param("userId") int userId, @Param("movieId") int movieId, @Param("score") int score, @Param("comment") String comment);

    int delete(@Param("userId") int userId, @Param("movieId") int movieId);

    List<Watched> queryWatchedScoreFetchMovieId(@Param("movieId") int movieId);
}
