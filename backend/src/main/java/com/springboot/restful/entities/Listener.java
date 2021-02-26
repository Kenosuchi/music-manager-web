package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "listener")
public class Listener {
    @Id
    @Column(name="listener_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listenerId;

    @Column(name="listener_name")
    private String listenerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="listener_account")
    private Account listenerAccount;

    @ManyToMany
    @JoinTable(name = "listener_artist_interest",
    joinColumns = @JoinColumn(name = "listener_id"),
    inverseJoinColumns = @JoinColumn(name = "artist_interest_id"))
    private Set<Artist> artistFollowed;

    @OneToMany(mappedBy = "listener")
    private Set<Playlist> listenerPlaylist;

    public Listener() {
    }

    public Listener(int listenerId, String listenerName, Account listenerAccount, Set<Artist> artistFollowed) {
        this.listenerId = listenerId;
        this.listenerName = listenerName;
        this.listenerAccount = listenerAccount;
        this.artistFollowed = artistFollowed;
    }
}
