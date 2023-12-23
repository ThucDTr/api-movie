package com.example.apimovie.controller;

import com.example.apimovie.entity.Genres;
import com.example.apimovie.repo.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000" ,"https://group8-power-of-love.netlify.app/"})
@RequestMapping("/api/genres")
public class GenresController {

    @Autowired
    private GenresRepository genresRepository;

    @GetMapping("/getAll")
    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }
}
