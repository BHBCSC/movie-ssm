package com.csc.movie.web.controller;

import com.csc.movie.entity.User;
import com.csc.movie.service.UserService;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
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

    @RequestMapping({"/mine"})
    public ModelAndView showMine(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("/user/mine");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.getMovieList(username);
        modelAndView.addObject("watchedList", user.getWatchedList());
        return modelAndView;
    }

}
