package com.springboot.restful.service;

import com.springboot.restful.dto.ListDomainDTO;
import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.entities.Artist;
import com.springboot.restful.entities.Genre;
import com.springboot.restful.entities.Song;
import com.springboot.restful.repository.ArtistRepository;
import com.springboot.restful.repository.GenreRepository;
import com.springboot.restful.repository.SongRepository;
import com.springboot.restful.utilities.Query;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private GenreRepository genreRepository;

    public ServiceResult findAll(Query query) {
        ServiceResult result = new ServiceResult();
        ListDomainDTO<SongDTO> songDTOs = retrieveDataWithPaginateAndSort(query);
        result.setData(songDTOs);
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Song song = songRepository.findById(id).orElse(null);
        assert song != null;
        SongDTO songDTO = new SongDTO(song);
        result.setData(songDTO);
        return result;
    }

    //    public ServiceResult findSongByArtist(int artistId){
//        ServiceResult result = new ServiceResult();
//        List<SongDTO> songDTOs =
//                convertEntitiesToDTOs(songRepository.findSongByArtist(artistId));
//        result.setData(songDTOs);
//        return result;
//    }
    public ServiceResult create(SongDTO songDTO) {
        ServiceResult result = new ServiceResult();
        Song song = convertDTOtoEntity(songDTO);
        result.setData(songRepository.save(song));
        return result;
    }

    public ServiceResult update(SongDTO songDTO) {
        ServiceResult result = new ServiceResult();
        Song song = convertDTOtoEntity(songDTO);
        if (!songRepository.findById(song.getSongId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            result.setData(songRepository.save(song));
        }
        return result;
    }

    public ServiceResult delete(int id) {
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

    public ServiceResult deleteMultipleUser(int[] idArr) {
        ServiceResult result = new ServiceResult();
        List<Song> songs = new ArrayList<>();
        for (int id : idArr) {
            Song song = songRepository.findById(id).orElse(null);
            if (song == null) {
                result.setStatus(ServiceResult.Status.FAILED);
                result.setMessage("Customer " + id + " Not Found");
                return result;
            }
            songs.add(song);
        }
        for (Song song : songs) {
            songRepository.delete(song);
        }
        result.setMessage("success");


        return result;
    }

    public Song convertDTOtoEntity(SongDTO songDTO) {
        Artist artist = artistRepository.findArtistByName(songDTO.getSongArtistName());
        Genre genre = genreRepository.findGenreByName(songDTO.getSongGenreName());
        if (genre == null) {
            genre = new Genre(songDTO.getSongGenreName());
        }
        return new Song(songDTO.getSongId(), songDTO.getSongTitle(), songDTO.getSongReleaseDate(), songDTO.getSongPlayTime(), artist, genre);
    }

    public ListDomainDTO<SongDTO> convertEntitiesToDTOs(List<Song> songs, int size) {
        List<SongDTO> songDTOS = new ArrayList<>();
        for (Song song : songs) {
            songDTOS.add(new SongDTO(song));
        }
        return new ListDomainDTO<>(songDTOS, size);
    }

    private ListDomainDTO<SongDTO> retrieveDataWithPaginateAndSort(Query query) {
        List<Song> songs = null;
        Sort sort = setupSortQuery(query);
        int dataLength = 0;
        if (sort != null) {
            PageRequest pageRequest = PageRequest.of(query.getOffset() - 1, query.getPageSize(), sort);
            if (query.getSearchValue().equals("")){
                songs = songRepository.findAll(pageRequest).getContent();
                dataLength = songRepository.getDataLength();
            }
            else {
                String title = "%" + query.getSearchValue() + "%";
                songs = songRepository.findSongByTitle(title, pageRequest).getContent();
                dataLength = songRepository.getDataLengthWithTitle(title);
            }
        }
        assert songs != null;
        return convertEntitiesToDTOs(songs, dataLength);
    }

    private Sort setupSortQuery(Query query) {
        Sort sort = null;
        if (query.getSortOrder().toLowerCase().equals("asc")) {
            sort = Sort.by(Sort.Direction.ASC, query.getOrderBy());
        } else if (query.getSortOrder().toLowerCase().equals("desc")) {
            sort = Sort.by(Sort.Direction.DESC, query.getOrderBy());
        }
        return sort;
    }
}
