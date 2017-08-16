package com.csc.movie.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class RedisSessionDAO extends AbstractSessionDAO {
    @Autowired
    private RedisTemplate redis;

    private static final String key = "session";


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);

        redis.opsForHash().put(key, sessionId, session);

        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return (Session) redis.opsForHash().get(key, sessionId);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        redis.opsForHash().put(key, session.getId(), session);

    }

    @Override
    public void delete(Session session) {
        redis.opsForHash().delete(key, session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return redis.opsForHash().values(key);
    }
}
