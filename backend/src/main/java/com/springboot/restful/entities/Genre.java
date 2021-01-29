package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name="genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(name="genre_name")
    private String genreName;

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }
}
