package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "song_artist")
    private Artist songArtist;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "song_genre")
    private Genre songGenre;

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
