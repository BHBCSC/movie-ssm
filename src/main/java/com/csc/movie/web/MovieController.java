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
        int userId;
        Movie movie;
        Watched watched;
        ModelAndView modelAndView = new ModelAndView("show");
        try {
            movie = movieService.getMovieById(movieId);
            modelAndView.addObject("movie", movie);

            userId = ((Integer) session.getAttribute("userId")).intValue();
            watched = movieService.movieWathced(userId, movieId);
            modelAndView.addObject("watched", watched);
        } catch (NullPointerException e) {
            modelAndView.addObject("watched", null);
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping({"/watched"})
    public ModelAndView watched(@PathVariable int movieId, @RequestParam("score") int score, @RequestParam("comment") String comment, HttpSession session) {
        Watched watched = new Watched(score, comment);
        int userId = ((Integer) session.getAttribute("userId")).intValue();
        movieService.doMovieWatched(userId, movieId, watched);
        return detail(movieId, session);
    }

    @RequestMapping({"/delete"})
    public ModelAndView delete(@PathVariable int movieId, HttpSession session) {
        int userId = ((Integer) session.getAttribute("userId")).intValue();
        movieService.doWatchedDelete(userId, movieId);
        return detail(movieId, session);
    }
}
