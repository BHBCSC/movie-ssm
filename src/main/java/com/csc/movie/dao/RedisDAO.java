package com.csc.movie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Component
public class RedisDAO {
    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }

    public void lsetMovieScoreUpdate(long index, int value) {
        Jedis jedis = jedisPool.getResource();
        jedis.lset("scoreModifiedTimes", index, String.valueOf(value));
    }

    public int lgetMovieScoreUpdate(long index) {
        Jedis jedis = jedisPool.getResource();
        return Integer.parseInt(jedis.lindex("scoreModifiedTimes", index));
    }
}
