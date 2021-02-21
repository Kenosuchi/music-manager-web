package com.springboot.restful.service;

import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.entities.Account;
import com.springboot.restful.entities.Artist;
import com.springboot.restful.entities.Genre;
import com.springboot.restful.entities.Song;
import com.springboot.restful.repository.ArtistRepository;
import com.springboot.restful.repository.GenreRepository;
import com.springboot.restful.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private GenreRepository genreRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        List<Song> songs = songRepository.findAll();
        List<SongDTO> songDTOs = convertEntitiesToDTOS(songs);
        result.setData(songDTOs);
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Song song = songRepository.findById(id).orElse(null);
        assert song != null;
        SongDTO songDTO = new SongDTO(song);
        result.setData(songDTO);
        return result;
    }
    public ServiceResult findSongByTitle(String title){
        ServiceResult result = new ServiceResult();
        title = "%"+title+"%";
        List<Song> songs = songRepository.findSongByTitle(title);
        List<SongDTO> songDTOs = convertEntitiesToDTOS(songs);
        result.setData(songDTOs);
        return result;
    }

    public ServiceResult orderBySongTitle(boolean asc){
        ServiceResult result = new ServiceResult();
        List<Song> songs;
        if(asc){
            songs = songRepository.orderBySongTitleAsc();
        }else{
            songs = songRepository.orderBySongTitleDesc();
        }
        List<SongDTO> songDTOs = convertEntitiesToDTOS(songs);
        result.setData(songDTOs);
        return result;
    }

    public ServiceResult  create(SongDTO songDTO){
        ServiceResult result = new ServiceResult();
        Song song = convertDTOtoEntities(songDTO);
        result.setData(songRepository.save(song));
        return result;
    }

    public ServiceResult  update(SongDTO songDTO){
        ServiceResult result = new ServiceResult();
        Song song = convertDTOtoEntities(songDTO);
        if (!songRepository.findById(song.getSongId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            result.setData(songRepository.save(song));
        }
        return result;
    }

    public ServiceResult  delete(int id){
        ServiceResult result = new ServiceResult();
        Song song = songRepository.findById(id).orElse(null);
        if (song == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            songRepository.delete(song);
            result.setMessage("success");
        }

        return result;
    }

    public ServiceResult deleteMultipleUser(int[] idArr){
        ServiceResult result = new ServiceResult();
        List<Song> songs = new ArrayList<>();
        for(int id:idArr){
            Song song  = songRepository.findById(id).orElse(null);
            if (song == null) {
                result.setStatus(ServiceResult.Status.FAILED);
                result.setMessage("Customer " +id+ " Not Found");
                return result;
            }
            songs.add(song);
        }
        for(Song song:songs){
            songRepository.delete(song);
        }
        result.setMessage("success");


        return result;
    }

    private Song convertDTOtoEntities(SongDTO songDTO){
        Artist artist = artistRepository.findArtistByName(songDTO.getSongArtistName());
        Genre genre = genreRepository.findGenreByName(songDTO.getSongGenreName());
        if(genre==null){
            genre = new Genre(songDTO.getSongGenreName());
        }
        return new Song(songDTO.getSongId(),songDTO.getSongTitle(),songDTO.getSongReleaseDate(),songDTO.getSongPlayTime(),artist,genre);
    }
    private List<Song> convertDTOStoEntities(SongDTO[] songDTOS){
        List<Song> songs = new ArrayList<>();
        for(SongDTO songDTO:songDTOS){
            Artist artist = artistRepository.findArtistByName(songDTO.getSongArtistName());
            Genre genre = genreRepository.findGenreByName(songDTO.getSongGenreName());
            songs.add(new Song(songDTO.getSongId(),songDTO.getSongTitle(),songDTO.getSongReleaseDate(),songDTO.getSongPlayTime(),artist,genre));
        }

        return songs;
    }
    private List<SongDTO> convertEntitiesToDTOS(List<Song> songs){
        List<SongDTO> songDTOS = new ArrayList<>();
        for(Song song: songs){
            songDTOS.add(new SongDTO(song));
        }
        return songDTOS;
    }
}
