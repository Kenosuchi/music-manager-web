package com.springboot.restful.repository;

import com.springboot.restful.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
    @Query(value = "select * from song where song.song_title like :title",nativeQuery = true)
    List<Song> findSongByTitle(String title);
    @Query(value = "select * from song where song.song_artist = :artistId",nativeQuery = true)
    List<Song> findSongByArtist(int artistId);
    @Query(value="select * from song order by song.song_title ASC",nativeQuery = true)
    List<Song> orderBySongTitleAsc();
    @Query(value="select * from song order by song.song_title DESC",nativeQuery = true)
    List<Song> orderBySongTitleDesc();
}
