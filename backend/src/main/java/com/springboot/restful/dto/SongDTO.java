package com.springboot.restful.dto;

import com.springboot.restful.entities.Listener;
import com.springboot.restful.entities.Song;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SongDTO {
    private int songId;
    private String songTitle;
    private String songArtistName;
    private String songGenreName;
    private Date songReleaseDate;
    private int songPlayTime;
    private List<Integer> listenerLiked;

    public SongDTO() {
    }

    public SongDTO(Song song) {
        this.songId=song.getSongId();
        this.songTitle = song.getSongTitle();
        this.songArtistName = song.getSongArtist().getArtistName();
        this.songGenreName = song.getSongGenre().getGenreName();
        this.songReleaseDate = song.getSongReleaseDate();
        this.songPlayTime = song.getSongPlayTime();
        this.listenerLiked = new ArrayList<>();
        if(song.getLikedListeners().size()>0) {
            for (Listener listener : song.getLikedListeners()) {
                this.listenerLiked.add(listener.getListenerId());
            }
        }
    }
}
