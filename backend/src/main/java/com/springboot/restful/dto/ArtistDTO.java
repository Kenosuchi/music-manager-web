package com.springboot.restful.dto;

import com.springboot.restful.entities.Artist;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ArtistDTO {
    private int artistId;
    private String artistName;
    private String artistDescription;
    private int artistAccountId;
    private int artistNumberOfFollowers;
    private List<SongDTO> artistSongs;

    public ArtistDTO() {
    }

    public ArtistDTO(Artist artist) {
        this.artistId = artist.getArtistId();
        this.artistName = artist.getArtistName();
        this.artistDescription = artist.getArtistDescription();
        this.artistAccountId = artist.getArtistAccount().getAccountId();
        this.artistNumberOfFollowers = artist.getArtistFollowed().size();
        this.artistSongs = new ArrayList<>();
    }

    public void setArtistSongs(List<SongDTO> artistSongs) {
        this.artistSongs = artistSongs;
    }
}
