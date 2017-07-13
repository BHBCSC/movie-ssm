package com.csc.movie.web;

import com.csc.movie.entity.Movie;
import com.csc.movie.entity.Watched;
import com.csc.movie.service.MovieService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/movie/{movieId}"})
public class MovieController {
    @Autowired
    MovieService movieService;

    public MovieController() {
    }

    @RequestMapping({"/"})
    public ModelAndView detail(@PathVariable int movieId, HttpSession session) {
        int userId = ((Integer) session.getAttribute("userId")).intValue();
        Movie movie = this.movieService.getMovieById(movieId);
        Watched watched = this.movieService.movieWathced(userId, movieId);
        System.out.println(movie.getMovieId());
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("movie", movie);
        modelAndView.addObject("watched", watched);
        return modelAndView;
    }

    @RequestMapping({"/watched"})
    public ModelAndView watched(@PathVariable int movieId, @RequestParam("score") int score, @RequestParam("comment") String comment, HttpSession session) {
        Watched watched = new Watched(score, comment);
        int userId = ((Integer) session.getAttribute("userId")).intValue();
        this.movieService.doMovieWatched(userId, movieId, watched);
        return this.detail(movieId, session);
    }

    @RequestMapping({"/delete"})
    public ModelAndView delete(@PathVariable int movieId, HttpSession session) {
        int userId = ((Integer) session.getAttribute("userId")).intValue();
        this.movieService.doWatchedDelete(userId, movieId);
        return this.detail(movieId, session);
    }
}
