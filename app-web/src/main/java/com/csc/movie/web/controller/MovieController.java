package com.csc.movie.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csc.movie.entity.Movie;
import com.csc.movie.entity.Watched;
import com.csc.movie.service.MovieService;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping({"/movie"})
public class MovieController {
    @Reference
    MovieService movieService;

    public MovieController() {
    }

    @RequestMapping({"/"})
    public ModelAndView movies(@RequestParam(value = "page", defaultValue = "1") int page) {
        int limit = 2;
        int offset = (page - 1) * limit;

        ModelAndView modelAndView = new ModelAndView("/movie/showAll");

        List<Movie> movieList = movieService.getMovies(offset, limit);
        int pages = movieService.getMoviePages(limit);
        modelAndView.addObject("movieList", movieList);
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("current", page);
        return modelAndView;
    }

    @RequestMapping({"/{movieId}"})
    public ModelAndView detail(@PathVariable int movieId, HttpSession session) {
        int userId;
        Movie movie;
        Watched watched;
        ModelAndView modelAndView = new ModelAndView("/movie/show");
        try {
            movie = movieService.getMovieByIdLimit(movieId);
            modelAndView.addObject("movie", movie);

            userId = (Integer) session.getAttribute("userId");
            watched = movieService.movieWathced(userId, movieId);
            modelAndView.addObject("watched", watched);
        } catch (NullPointerException e) {
            modelAndView.addObject("watched", null);
            return modelAndView;
        }
        return modelAndView;
    }

    @RequiresUser
    @RequestMapping({"/{movieId}/watched"})
    public ModelAndView watched(@PathVariable int movieId, @RequestParam("score") int score, @RequestParam("comment") String comment, HttpSession session) {
        Watched watched = new Watched(score, comment);

        int userId = (Integer) session.getAttribute("userId");
        movieService.doMovieWatched(userId, movieId, watched);
        return detail(movieId, session);
    }

    @RequiresUser
    @RequestMapping({"/{movieId}/watched/delete"})
    public ModelAndView deleteWatched(@PathVariable int movieId, HttpSession session) {
        int userId = (Integer) session.getAttribute("userId");
        movieService.doWatchedDelete(userId, movieId);
        return detail(movieId, session);
    }

    @RequestMapping({"/{movieId}/celebrities"})
    public ModelAndView celebrities(@PathVariable int movieId) {
        Movie movie = movieService.getMovieById(movieId);
        ModelAndView modelAndView = new ModelAndView("/movie/celebrities");
        modelAndView.addObject("movie", movie);

        return modelAndView;
    }

    @RequiresRoles("admin")
    @RequestMapping({"/{movieId}/delete"})
    public ModelAndView delete(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/movie/");
        movieService.deleteMovie(id);

        return modelAndView;
    }

    @RequiresRoles("admin")
    @RequestMapping({"/{movieId}/modify"})
    public ModelAndView modify(@PathVariable int movieId, String name) {
        ModelAndView modelAndView = new ModelAndView("redirect:/movie/");

        Movie movie = new Movie();
        movie.setMovieId(movieId);
        movie.setName(name);
        movieService.modifyMovie(movie);

        return modelAndView;
    }

    @RequiresRoles("admin")
    @RequestMapping({"/add"})
    public String add(@RequestParam(required = false) String name, Model model) {
        if (name != null) {
            if (name != "" && !name.equals("")) {
                Movie movie = new Movie();
                movie.setName(name);
                movieService.addMovie(movie);
                model.addAttribute("message", "添加成功");
            }
        }

        return "/movie/add";
    }

}
