package com.example.apimovie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimovie.entity.Movie;
import com.example.apimovie.entity.MovieGenres;
import com.example.apimovie.repo.MovieGenresRepository;
import com.example.apimovie.repo.MovieRepository;

@RestController
@RequestMapping("/api/movieGenres")
@CrossOrigin(origins = {"http://localhost:3000" ,"https://group8-power-of-love.netlify.app/"})
public class MovieGenresController {
    @Autowired
    MovieGenresRepository movieGenresRepository;
    @Autowired
    MovieRepository movieRepository;
    @GetMapping("/all")
    public List<MovieGenres> getAllMovieGenres(){
        return movieGenresRepository.findAll();
    }
    @GetMapping("byMovieId/{id}")
    public List<Movie> getMovieGenresByMovieId(@PathVariable int id){
        List<MovieGenres> movieGenresList = new ArrayList<>();
        Movie movie = movieRepository.findById(id).get();
        movieGenresList = movieGenresRepository.findByMovie(id);
        List<Movie> movieList = new ArrayList<>();
        for (MovieGenres movieGenres: movieGenresList) {
            movieList.add(movieGenres.getMovie());
        }
        return movieList;
    }
}
