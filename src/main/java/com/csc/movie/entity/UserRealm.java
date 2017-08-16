package com.csc.movie.entity;

import com.csc.movie.service.AccountService;
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
    @Autowired
    AccountService accountService;

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

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), user.getPassword(), getName()
        );

        return authenticationInfo;
    }
}
