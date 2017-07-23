package com.csc.movie.web;

import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

@Controller
@RequestMapping({"/account"})
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/login"})
    public String login() {
        return "account/login";
    }

    @RequestMapping(value = {"/dologin"}, method = {RequestMethod.POST})
    public String dologin(User user, HttpSession session) {
        if ((user = this.userService.login(user.getUsername(), user.getPassword())) != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getId());

            return "redirect:/user/mine";
        } else {
            return "account/login";
        }
    }

    @RequestMapping({"/register"})
    public String register() {
        return "register";
    }

    @RequestMapping(
            value = {"/doreg"},
            method = {RequestMethod.POST}
    )
    public String doreg(User user) {
        return userService.register(user.getUsername(), user.getPassword()) ? "success" : "failure";
    }

}
