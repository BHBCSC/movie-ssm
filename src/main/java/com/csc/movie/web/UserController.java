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
 * Created by Administrator on 2017/6/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public ModelAndView dologin(User user, HttpSession session) {

        if((user = userService.login(user.getUsername(),user.getPassword())) != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getId());

            System.out.println(user);
            return showMine(session);
        }
        else
            return new ModelAndView("login");
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/doreg", method = RequestMethod.POST)
    public String doreg(User user){
        if(userService.register(user.getUsername(),user.getPassword()))
            return "success";
        else
            //用户名重复
            return "failure";
    }

    @RequestMapping(value = "/mine")
    public ModelAndView showMine(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("mine");
        User user = userService.getMovieList((Integer) session.getAttribute("userId"));
        //session.setAttribute("watchedList", user.getWatchedList());
        modelAndView.addObject("watchedList", user.getWatchedList());
        //User user = userService.queryFetchMovie(user.getId());
        return modelAndView;
    }
}
