package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @Column(name="artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistId;

    @Column(name="artist_name")
    private String artistName;

    @Column(name="artist_description")
    private String artistDescription;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "artist_account")
    private Account artistAccount;

    public Artist() {
    }

    public Artist(int artistId, String artistName, String artistDescription, Account artistAccount) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistDescription = artistDescription;
        this.artistAccount = artistAccount;
    }
}
