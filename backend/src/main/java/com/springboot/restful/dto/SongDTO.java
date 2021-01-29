package com.springboot.restful.dto;

import com.springboot.restful.entities.Song;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class SongDTO {
    private int songId;
    private String songTitle;
    private String songArtistName;
    private String songGenreName;
    private Date songReleaseDate;
    private int songPlayTime;

    public SongDTO() {
    }

    public SongDTO(Song song) {
        this.songId=song.getSongId();
        this.songTitle = song.getSongTitle();
        this.songArtistName = song.getSongArtist().getArtistName();
        this.songGenreName = song.getSongGenre().getGenreName();
        this.songReleaseDate = song.getSongReleaseDate();
        this.songPlayTime = song.getSongPlayTime();
    }
}
