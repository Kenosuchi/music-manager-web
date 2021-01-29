package com.springboot.restful.repository;

import com.springboot.restful.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
    @Query(value = "select * from song where song.song_name = :name",nativeQuery = true)
    List<Song> findSongByName(String name);
}
