package com.springboot.restful.dto;

import com.springboot.restful.entities.Album;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AlbumDTO {
    private int albumId;
    private String albumTitle;
    private String albumDescription;
    private Date albumUpdatedDate;

    public AlbumDTO() {
    }

    public AlbumDTO(Album album) {
        this.albumId = album.getAlbumId();
        this.albumDescription = album.getAlbumDescription();
        this.albumTitle = album.getAlbumTitle();
        this.albumUpdatedDate = album.getAlbumUpdatedDate();
    }
}
