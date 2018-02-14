package com.csc.movie.shiro.filter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csc.movie.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    @Reference
    AccountService accountService;

    private static final Log log = LogFactory.getLog(MyFormAuthenticationFilter.class);

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("login success");
        String username = (String) token.getPrincipal();

        int id = accountService.getId(username);
        log.info("filter username + id is " + username + id);
        subject.getSession().setAttribute("userId", id);

        if (WebUtils.getSavedRequest(request) != null)
            if (WebUtils.getSavedRequest(request).getRequestURI().indexOf("account") != -1) {
                WebUtils.getAndClearSavedRequest(request);

                WebUtils.redirectToSavedRequest(request, response, "/user/mine");

                return false;
            }

        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        System.out.println("Login Failure");
        System.out.println("principal is " + token.getPrincipal() + "  credentials " + token.getCredentials());
        return super.onLoginFailure(token, e, request, response);
    }
}
