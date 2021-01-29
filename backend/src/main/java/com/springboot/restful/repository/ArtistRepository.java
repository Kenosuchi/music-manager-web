package com.springboot.restful.repository;

import com.springboot.restful.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
    public interface ArtistRepository extends JpaRepository<Artist,Integer> {
    //@Query("select a from Artist a where a.artistName = :name")
    @Query(value = "select * from artist a where a.artist_name = :name",nativeQuery = true)
    Artist findArtistByName(@Param("name") String name);
}
