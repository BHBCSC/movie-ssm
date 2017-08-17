package com.csc.movie.web.controller;

import com.csc.movie.entity.Movie;
import com.csc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Controller
@RequestMapping({"/search"})
public class SearchController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView search(String text, @RequestParam(value = "page", defaultValue = "1") int page) {
        int limit = 2;

        ModelAndView modelAndView = new ModelAndView("/search/result");

        int offset = (page - 1) * limit;
        List<Movie> movieList = movieService.getMoviesByName(text, offset, limit);
        int result = movieService.getMoviesByNameCount(text);
        int pages = (result % limit == 0) ? (result / limit) : (result / limit + 1);
        modelAndView.addObject("movieList", movieList);
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("text", text);
        modelAndView.addObject("current", page);
        return modelAndView;
    }
}
