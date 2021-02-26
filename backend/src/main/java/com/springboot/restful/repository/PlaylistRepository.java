package com.springboot.restful.repository;

import com.springboot.restful.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
    @Query(value = "select * from playlist where playlist.playlist_listener = :id",nativeQuery = true)
    Set<Playlist> findPlaylistByListenerId(int id);
}
