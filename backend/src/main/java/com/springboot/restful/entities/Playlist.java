package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "playlist")
@Getter
@Setter
public class Playlist {
    @Id
    @Column(name="playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistId;

    @Column(name = "playlist_title")
    private String playlistTitle;

    @Column(name = "playlist_update_date")
    private Date playlistUpdateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_listener")
    private Listener listener;

    @ManyToMany
    @JoinTable(name = "playlist_song",
    joinColumns = @JoinColumn(name = "playlist_id"),
    inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> playlistSongs;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistTitle, Date playlistUpdateDate) {
        this.playlistId = playlistId;
        this.playlistTitle = playlistTitle;
        this.playlistUpdateDate = playlistUpdateDate;
    }
}
