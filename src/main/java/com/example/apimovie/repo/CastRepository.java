package com.example.apimovie.repo;

import com.example.apimovie.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastRepository extends JpaRepository<Cast,Integer> {
    @Query(value = "select c.* from movie m join movie_cast mc on m.id=mc.id_movie join `cast` c on mc.id_cast=c.id where m.id=:id", nativeQuery = true)
    List<Cast>getCastByMovie(int id);
}
