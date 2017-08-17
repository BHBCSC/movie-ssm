package com.csc.movie.web;

import com.csc.movie.util.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class AccountInterceptor implements HandlerInterceptor {

    //登陆成功后将username userid放入session
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*HttpSession session = request.getSession();
        String username = CookieUtil.getCookieValue(request, "userName");
        String userId = CookieUtil.getCookieValue(request, "userId");

        if (username == null || userId == null) {
            response.sendRedirect("/account/login");
            return false;
        } else {
            System.out.println("url is" + request.getRequestURL());
            if ((request.getRequestURL().indexOf("account") != -1)) {
                response.sendRedirect("/user/mine");
                return false;
            }
            session.setAttribute("username", username);
            session.setAttribute("userId", Integer.valueOf(userId));
            return true;
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
