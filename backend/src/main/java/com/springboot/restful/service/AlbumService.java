package com.springboot.restful.service;

import com.springboot.restful.dto.AlbumDTO;
import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.entities.Album;
import com.springboot.restful.entities.Song;
import com.springboot.restful.repository.AlbumRepository;
import com.springboot.restful.utilities.ConvertDaoAndDto;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AlbumService implements ConvertDaoAndDto<Album, AlbumDTO> {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongService songService;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        List<Album> albums = albumRepository.findAll();
        List<AlbumDTO> albumDTOs = convertEntitiesToDTOs(albums);
        result.setData(albumDTOs);
        return result;
    }

    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Album album = albumRepository.findById(id).orElse(null);
        assert album != null;
        AlbumDTO albumDTO = new AlbumDTO(album);
        result.setData(albumDTO);
        return result;
    }

    public ServiceResult findSongsInAlbum(int id){
        ServiceResult result = new ServiceResult();
        Album album = albumRepository.findById(id).orElse(null);
        assert album != null;
        Set<SongDTO> songDTOs = convertSongToSongDTO(album.getAlbumSongs());
        result.setData(songDTOs);
        return result;
    }

    public ServiceResult create(AlbumDTO albumDTO){
        ServiceResult result = new ServiceResult();
        Album album = convertDTOtoEntity(albumDTO);
        result.setData(albumRepository.save(album));
        return result;
    }

    public ServiceResult update(AlbumDTO albumDTO){
        ServiceResult result = new ServiceResult();
        Album album = convertDTOtoEntity(albumDTO);
        if (!albumRepository.findById(album.getAlbumId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Album Not Found");
        } else {
            result.setData(albumRepository.save(album));
        }
        return result;
    }

    public ServiceResult delete(int id){
        ServiceResult result = new ServiceResult();
        Album album = albumRepository.findById(id).orElse(null);
        if (album == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Album Not Found");
        } else {
            albumRepository.delete(album);
            result.setMessage("success");
        }

        return result;
    }

    @Override
    public Album convertDTOtoEntity(AlbumDTO albumDTO) {
        Album album = new Album();
        album.setAlbumDescription(albumDTO.getAlbumDescription());
        album.setAlbumId(albumDTO.getAlbumId());
        album.setAlbumTitle(albumDTO.getAlbumTitle());
        album.setAlbumUpdatedDate(albumDTO.getAlbumUpdatedDate());
        return album;
    }
    @Override
    public List<AlbumDTO> convertEntitiesToDTOs(List<Album> entity) {
        List<AlbumDTO> albumDTOs = new ArrayList<>();
        for(Album album: entity){
            albumDTOs.add(new AlbumDTO(album));
        }
        return albumDTOs;
    }
    private Set<SongDTO> convertSongToSongDTO(Set<Song> songs){
        Set<SongDTO> songDTOs = new HashSet<>();
        for(Song song:songs){
            songDTOs.add(new SongDTO(song));
        }
        return songDTOs;
    }
}
