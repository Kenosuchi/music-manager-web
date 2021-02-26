package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "album")
@Getter
@Setter
public class Album {
    @Id
    @Column(name="album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @Column(name="album_title")
    private String albumTitle;

    @Column(name="album_description")
    private String albumDescription;

    @Column(name = "album_updated_date")
    private Date albumUpdatedDate;

    @ManyToMany
    @JoinTable(name = "album_song",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> albumSongs;

    @ManyToMany
    @JoinTable(name = "album_like",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "listener_like_id"))
    private Set<Listener> albumLikes;

    public Album() {
    }

    public Album(int albumId, String albumName, String albumDescription, Date albumUpdatedDate, Set<Song> albumSongs) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumUpdatedDate = albumUpdatedDate;
        this.albumSongs = albumSongs;
    }
}
