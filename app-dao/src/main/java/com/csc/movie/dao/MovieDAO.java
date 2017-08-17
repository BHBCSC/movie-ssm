package com.csc.movie.dao;

import com.csc.movie.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/6/11 0011.
 */
public interface MovieDAO {
    Movie queryById(@Param("id") int id, @Param("limit") int limit);

    List<Movie> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int count();

    void update(@Param("movieId") int movieId, @Param("score") float score);

    List<Movie> queryLikeName(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

    int queryLikeNameCount(String name);

    void add(String name);

    void modify(@Param("movieId") int id, @Param("name") String name);

    void delete(int id);
}
