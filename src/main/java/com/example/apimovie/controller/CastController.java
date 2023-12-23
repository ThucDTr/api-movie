package com.example.apimovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimovie.entity.Cast;
import com.example.apimovie.repo.CastRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:3000" ,"https://group8-power-of-love.netlify.app/"})
@RequestMapping("/api/cast")
public class CastController {
    @Autowired
    CastRepository castRepository;

    @GetMapping("/byMovie/{id}")
    public List<Cast>getCastByMovie(@PathVariable int id){
        return castRepository.getCastByMovie(id);
    }
}
