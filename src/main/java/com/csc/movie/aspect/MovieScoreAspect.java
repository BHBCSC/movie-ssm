package com.csc.movie.aspect;

import com.csc.movie.dao.RedisDAO;
import com.csc.movie.service.MovieService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Aspect
@Component
public class MovieScoreAspect {
    @Autowired
    MovieService movieService;
    @Autowired
    RedisDAO redisDAO;

    @Pointcut("execution(* com.csc.movie.dao.WatchedDAO.*(..)) && !execution(* com.csc.movie.dao.WatchedDAO.query*(..))")
    public void updateScorePointCut() {
    }

    @Around("updateScorePointCut()")
    public Object updateScorePointcut(ProceedingJoinPoint point) throws Throwable {
        int movieId = 0;
        Object[] values = point.getArgs();
        //固定movieId是在第二个
        movieId = (int) values[1];

        int limitUpdateTime = 2;

        int modifiedTime = redisDAO.lgetMovieScoreUpdate(movieId);
        if (modifiedTime >= limitUpdateTime) {
            redisDAO.lsetMovieScoreUpdate(movieId, 0);
            movieService.updateMovieScore(movieId);
        } else {
            redisDAO.lsetMovieScoreUpdate(movieId, modifiedTime + 1);
        }

        return point.proceed();
    }
}
