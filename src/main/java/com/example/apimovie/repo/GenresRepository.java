package com.example.apimovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apimovie.entity.Genres;

@Repository
public interface GenresRepository extends JpaRepository<Genres,Integer> {

}
