package com.csc.movie.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csc.movie.dao.CelebrityDAO;
import com.csc.movie.entity.Celebrity;
import com.csc.movie.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CelebrityServiceImpl implements CelebrityService {
    @Autowired
    CelebrityDAO celebrityDAO;

    @Override
    public Celebrity getCelebrityByid(int celebrityId) {
        return celebrityDAO.queryById(celebrityId, 6);
    }
}
