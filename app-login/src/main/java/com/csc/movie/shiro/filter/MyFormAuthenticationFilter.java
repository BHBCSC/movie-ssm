package com.csc.movie.shiro.filter;

import com.csc.movie.service.AccountService;
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
    @Autowired
    AccountService accountService;

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String username = (String) token.getPrincipal();

        int id = accountService.getId(username);
        subject.getSession().setAttribute("userId", id);

        if (WebUtils.getSavedRequest(request) != null)
            if (WebUtils.getSavedRequest(request).getRequestURI().indexOf("account") != -1) {
                WebUtils.getAndClearSavedRequest(request);

                WebUtils.redirectToSavedRequest(request, response, "/user/mine");

                return false;
            }

        return super.onLoginSuccess(token, subject, request, response);
    }
}
