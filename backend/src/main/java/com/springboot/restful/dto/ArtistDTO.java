package com.springboot.restful.dto;

import com.springboot.restful.entities.Artist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistDTO {
    private int artistId;
    private String artistName;
    private String artistDescription;
    private int artistAccountId;
    private int artistNumberOfFollowers;

    public ArtistDTO() {
    }

    public ArtistDTO(Artist artist) {
        this.artistId = artist.getArtistId();
        this.artistName = artist.getArtistName();
        this.artistDescription = artist.getArtistDescription();
        this.artistAccountId = artist.getArtistAccount().getAccountId();
        this.artistNumberOfFollowers = artist.getArtistFollowed().size();
    }
}
