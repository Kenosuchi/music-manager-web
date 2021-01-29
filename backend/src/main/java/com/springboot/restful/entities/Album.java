package com.springboot.restful.entities;

import javax.persistence.*;

public class Album {
    @Id
    @Column(name="album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @Column(name="album_title")
    private String albumName;

    @Column(name="album_description")
    private String albumDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_updated_date")
    private Account albumUpdatedDate;

    public Album() {
    }

    public Album(int albumId, String albumName, String albumDescription, Account albumUpdatedDate) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDescription = albumDescription;
        this.albumUpdatedDate = albumUpdatedDate;
    }
}
