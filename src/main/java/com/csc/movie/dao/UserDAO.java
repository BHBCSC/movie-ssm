package com.csc.movie.dao;

import com.csc.movie.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public interface UserDAO {
    User query(@Param("username") String username,@Param("password")String password);

    User queryById(int id);

    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    void add(@Param("username") String username,@Param("password") String password) throws DuplicateKeyException;

    User queryFetchMovie(int id);

    User queryByUserName(@Param("username") String username);
}
