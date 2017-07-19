package com.csc.movie.dao;

import com.csc.movie.entity.Celebrity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/6/11 0011.
 */
public interface CelebrityDAO {
    Celebrity queryById(int id);

    List<Celebrity> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int count();

    List<Celebrity> queryByMovie(int actorId);
}
