package com.springboot.restful.dto;

import com.springboot.restful.entities.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    private int genreId;
    private String genreName;

    public GenreDTO() {
    }

    public GenreDTO(Genre genre) {
        this.genreId = genre.getGenreId();
        this.genreName = genre.getGenreName();
    }
}
