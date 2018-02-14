package com.csc.movie.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csc.movie.entity.User;
import com.csc.movie.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class UserRealm extends AuthorizingRealm {
    @Reference
    private AccountService accountService;

    //private static final Log log = LogFactory.getLog(AuthorizingRealm.class);

    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();

        Set<String> roles = accountService.getRoles(username);
        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        User user = accountService.getUser(username);

        if (user == null)
            throw new UnknownAccountException();

        System.out.println(("realm's username:" + user.getUsername() + "password is " + user.getPassword()));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), user.getPassword(), getName()
        );

        return authenticationInfo;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
