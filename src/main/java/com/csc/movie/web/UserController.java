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

    @RequestMapping({"/mine"})
    public ModelAndView showMine(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("mine");
        User user = userService.getMovieList(((Integer) session.getAttribute("userId")));
        modelAndView.addObject("watchedList", user.getWatchedList());
        return modelAndView;
    }
}
