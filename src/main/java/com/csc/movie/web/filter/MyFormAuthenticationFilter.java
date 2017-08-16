package com.csc.movie.web.filter;

import com.csc.movie.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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

        Logger logger = Logger.getLogger(MyFormAuthenticationFilter.class);

        logger.info("url is" + ((HttpServletRequest) request).getRequestURL());
        System.out.println("url is" + ((HttpServletRequest) request).getRequestURL());
        if (WebUtils.getSavedRequest(request) != null)
            if (WebUtils.getSavedRequest(request).getRequestURI().indexOf("account") != -1) {
                WebUtils.getAndClearSavedRequest(request);

                WebUtils.redirectToSavedRequest(request, response, "/user/mine");

                return false;
            }

        return super.onLoginSuccess(token, subject, request, response);
    }
}
