package com.csc.movie.dao;

import com.csc.movie.entity.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/6/11 0011.
 */
public interface ActorDAO {
    Actor queryById(int id);

    List<Actor> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int count();

    List<Actor>queryByMovie(int actorId);
}
