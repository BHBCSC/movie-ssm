package com.csc.movie.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csc.movie.entity.User;
import com.csc.movie.service.AccountService;
import com.csc.movie.service.UserService;
import com.csc.movie.shiro.filter.MyFormAuthenticationFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

@Controller
@RequestMapping({"/account"})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Reference
    private UserService userService;

    @RequestMapping({"/unauthorized"})
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login(HttpServletRequest request) {

        //========
        /*String userName = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        System.out.println("added login");

        if(userName != null && password != null){
            subject.login(token);
            if (subject.isAuthenticated()) {
                return new ModelAndView("/user/mine");
            }
        }*/



        ModelAndView mv = new ModelAndView("/account/login");

        System.out.println(SecurityUtils.getSubject().isAuthenticated());
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        //已经登陆过
        if (SecurityUtils.getSubject().isAuthenticated()) {
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userService.getMovieList(username);
            mv.addObject("watchedList", user.getWatchedList());
            mv.setViewName("/user/mine");
            return mv;
        }


        String exceptionClassName = (String) request.getAttribute(MyFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String error = null;
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                error = "用户名/密码错误";
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                error = "用户名/密码错误";
            } else if (AuthenticationException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
            } else if (exceptionClassName != null) {
                error = "其他错误：" + exceptionClassName;
            }
            mv.addObject("error", error);
        }

        return mv;
    }

    @RequestMapping({"/register"})
    public String register() {
        return "account/register";
    }

    @RequestMapping(
            value = {"/doreg"},
            method = {RequestMethod.POST}
    )
    public String doreg(User user) {
        return accountService.register(user.getUsername(), user.getPassword()) ? "success" : "failure";
    }

    @RequestMapping({"/checkUserName"})
    public User checkUserName(String username) {
        System.out.println(username);
        return accountService.getUser(username);
    }

    @RequestMapping({"/setting"})
    public String setting() {
        return "account/setting";
    }
}
