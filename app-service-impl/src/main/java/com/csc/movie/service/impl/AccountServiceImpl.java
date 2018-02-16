//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.csc.movie.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csc.movie.dao.UserDAO;
import com.csc.movie.entity.User;
import com.csc.movie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(String username) {
        return userDAO.queryByUserName(username);
    }

    public int getId(String username) {
        return userDAO.queryUserIdByUserName(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userDAO.queryRoles(username);
    }

    public User login(String username, String password) {
        return userDAO.query(username, password);
    }

    public boolean register(String username, String password) {
        try {
            userDAO.add(username, password);
            return true;
        } catch (DuplicateKeyException var4) {
            return false;
        }
    }

}
