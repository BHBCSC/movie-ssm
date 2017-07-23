package com.csc.movie.web;

import com.csc.movie.entity.Celebrity;
import com.csc.movie.entity.User;
import com.csc.movie.service.CelebrityService;
import com.csc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/celebrity"})
public class CelebrityController {
    @Autowired
    private CelebrityService celebrityService;

    public CelebrityController() {
    }

    @RequestMapping({"/{celebrityId}"})
    public ModelAndView show(@PathVariable int celebrityId, HttpSession session) {
        Celebrity celebrity;
        ModelAndView modelAndView = new ModelAndView("/celebrity/show");

        celebrity = celebrityService.getCelebrityByid(celebrityId);
        modelAndView.addObject("celebrity", celebrity);

        return modelAndView;
    }
}
