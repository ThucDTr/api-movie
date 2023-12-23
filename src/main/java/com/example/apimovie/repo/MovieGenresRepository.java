package com.example.apimovie.repo;

import com.example.apimovie.entity.MovieGenres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieGenresRepository extends JpaRepository<MovieGenres, Integer> {
    List<MovieGenres> findByMovie(int id);
}
