package com.csc.movie.web.controller;

import com.csc.movie.entity.User;
import com.csc.movie.service.AccountService;
import com.csc.movie.util.CookieUtil;
import com.csc.movie.web.filter.MyFormAuthenticationFilter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

@Controller
@RequestMapping({"/account"})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping({"/unauthorized"})
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping({"/login"})
    public ModelAndView login(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("/account/login");

        //已经登陆过
        if (SecurityUtils.getSubject().isAuthenticated()) {
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
            }/*else if(AuthenticationException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
            }*/ else if (exceptionClassName != null) {
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
