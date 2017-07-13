//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.csc.movie.web;

import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping(
            value = {"/dologin"},
            method = {RequestMethod.POST}
    )
    public ModelAndView dologin(User user, HttpSession session) {
        if ((user = this.userService.login(user.getUsername(), user.getPassword())) != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", Integer.valueOf(user.getId()));
            System.out.println(user);
            return this.showMine(session);
        } else {
            return new ModelAndView("login");
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
        return this.userService.register(user.getUsername(), user.getPassword()) ? "success" : "failure";
    }

    @RequestMapping({"/mine"})
    public ModelAndView showMine(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("mine");
        User user = this.userService.getMovieList(((Integer) session.getAttribute("userId")).intValue());
        modelAndView.addObject("watchedList", user.getWatchedList());
        return modelAndView;
    }
}
