
package com.csc.movie.dao;

import com.csc.movie.entity.Watched;
import org.apache.ibatis.annotations.Param;

public interface WatchedDAO {
    Watched queryWatched(@Param("userId") int userId, @Param("movieId") int movieId);

    void insertWatched(@Param("userId") int userId, @Param("movieId") int movieId, @Param("score") int score, @Param("comment") String comment);

    void updateWatched(@Param("userId") int userId, @Param("movieId") int movieId, @Param("score") int score, @Param("comment") String comment);

    int deleteWatched(@Param("userId") int userId, @Param("movieId") int movieId);
}
