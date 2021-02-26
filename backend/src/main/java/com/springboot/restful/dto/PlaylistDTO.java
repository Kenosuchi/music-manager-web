package com.springboot.restful.dto;

import com.springboot.restful.entities.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PlaylistDTO {
    private int playlistId;
    private String playlistTitle;
    private Date playlistUpdateDate;
    private Set<SongDTO> songs;

    public PlaylistDTO() {
    }

    public PlaylistDTO(Playlist playlist) {
        this.playlistId = playlist.getPlaylistId();
        this.playlistTitle = playlist.getPlaylistTitle();
        this.playlistUpdateDate = playlist.getPlaylistUpdateDate();
    }
}
