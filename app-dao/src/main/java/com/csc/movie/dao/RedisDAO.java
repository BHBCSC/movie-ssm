package com.csc.movie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Component
public class RedisDAO {
    @Autowired
    private StringRedisTemplate stringRedis;


    public void set(String key, String value) {
        stringRedis.opsForValue().set(key, value);
    }

    public String get(String key) {
        return stringRedis.opsForValue().get(key);
    }

    public void lsetMovieScoreUpdate(long index, int value) {
        stringRedis.opsForList().set("scoreModifiedTimes", index, String.valueOf(value));
    }

    public int lgetMovieScoreUpdate(long index) {
        return Integer.parseInt(stringRedis.opsForList().index("scoreModifiedTimes", index));
    }

}


