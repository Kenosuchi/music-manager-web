package com.springboot.restful.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {
    @Id
    @Column(name="song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;

    @Column(name="song_title")
    private String songTitle;

    @Column(name="song_release_date")
    private Date songReleaseDate;

    @Column(name="song_playtime")
    private int songPlayTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "song_artist")
    @JsonIgnore
    private Artist songArtist;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "song_genre")
    @JsonIgnore
    private Genre songGenre;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="album_song",
    joinColumns = @JoinColumn(name = "song_id"),
    inverseJoinColumns = @JoinColumn(name="album_id"))
    private Set<Album> albumSet;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "playlist_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private Set<Playlist> playlists;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "song_like",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "listener_like_id"))
    private Set<Listener> likedListeners;

    public Song() {
    }

    public Song(int songId,String songTitle, Date songReleaseDate, int songPlayTime, Artist songArtist, Genre songGenre) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.songReleaseDate = songReleaseDate;
        this.songPlayTime = songPlayTime;
        this.songArtist = songArtist;
        this.songGenre = songGenre;
    }
}
