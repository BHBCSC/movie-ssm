package com.csc.movie.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csc.movie.entity.Celebrity;
import com.csc.movie.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/celebrity"})
public class CelebrityController {
    @Reference
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
