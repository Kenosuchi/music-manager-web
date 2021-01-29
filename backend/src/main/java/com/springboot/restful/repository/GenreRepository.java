package com.springboot.restful.repository;

import com.springboot.restful.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    @Query(value = "select * from genre g where g.genre_name = :name",nativeQuery = true)
    Genre findGenreByName(@Param("name") String name);
}
