package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_account")
    private Account artistAccount;

    @OneToMany(mappedBy = "songArtist")
    private Set<Song> artistSongs;

    @ManyToMany
    @JoinTable(name = "listener_artist_interest",
            joinColumns = @JoinColumn(name = "artist_interest_id"),
            inverseJoinColumns = @JoinColumn(name = "listener_id"))
    private Set<Listener> artistFollowed;

    public Artist() {
    }

}
