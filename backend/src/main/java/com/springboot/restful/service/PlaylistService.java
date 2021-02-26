package com.springboot.restful.service;

import com.springboot.restful.dto.PlaylistDTO;
import com.springboot.restful.dto.ListenerDTO;
import com.springboot.restful.dto.PlaylistDTO;
import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.entities.Playlist;
import com.springboot.restful.entities.Listener;
import com.springboot.restful.entities.Playlist;
import com.springboot.restful.entities.Song;
import com.springboot.restful.repository.PlaylistRepository;
import com.springboot.restful.utilities.ConvertDaoAndDto;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlaylistService implements ConvertDaoAndDto<Playlist, PlaylistDTO> {
    @Autowired
    private PlaylistRepository playlistRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        List<Playlist> playlists = playlistRepository.findAll();
        List<PlaylistDTO> playlistDTOs = convertEntitiesToDTOs(playlists);
        result.setData(playlistDTOs);
        return result;
    }
    public ServiceResult findById(int id){
        ServiceResult result = new ServiceResult();
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if(playlist!=null){
            result.setData(new PlaylistDTO(playlist));
        }
        return result;
    }
    public ServiceResult findPlaylistByListenerId(int id){
        ServiceResult result = new ServiceResult();
        Set<PlaylistDTO> playlistDTOs
                = convertPlaylistToPlaylistDTO(playlistRepository.findPlaylistByListenerId(id));
        result.setData(playlistDTOs);
        return result;
    }
    public ServiceResult findSongsInPlaylist(int id){
        ServiceResult result = new ServiceResult();
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if(playlist!=null){
            Set<SongDTO> songDTOs = convertSongsToSongDTOs(playlist.getPlaylistSongs());
            result.setData(songDTOs);
        }
        return result;
    }

    public ServiceResult create(PlaylistDTO playlistDTO){
        ServiceResult result = new ServiceResult();
        Playlist playlist = convertDTOtoEntity(playlistDTO);
        result.setData(playlistRepository.save(playlist));
        return result;
    }

    public ServiceResult update(PlaylistDTO playlistDTO){
        ServiceResult result = new ServiceResult();
        Playlist playlist = convertDTOtoEntity(playlistDTO);
        if (!playlistRepository.findById(playlist.getPlaylistId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Playlist Not Found");
        } else {
            result.setData(playlistRepository.save(playlist));
        }
        return result;
    }

    public ServiceResult delete(int id){
        ServiceResult result = new ServiceResult();
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Playlist Not Found");
        } else {
            playlistRepository.delete(playlist);
            result.setMessage("success");
        }

        return result;
    }
    @Override
    public Playlist convertDTOtoEntity(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        playlist.setPlaylistId(playlistDTO.getPlaylistId());
        playlist.setPlaylistTitle(playlistDTO.getPlaylistTitle());
        playlist.setPlaylistUpdateDate(playlistDTO.getPlaylistUpdateDate());
        return playlist;
    }

    @Override
    public List<PlaylistDTO> convertEntitiesToDTOs(List<Playlist> entity) {
        List<PlaylistDTO> playlistDTOs = new ArrayList<>();
        for(Playlist playlist:entity){
            playlistDTOs.add(new PlaylistDTO(playlist));
        }
        return playlistDTOs;
    }

    private Set<SongDTO> convertSongsToSongDTOs(Set<Song> entity) {
        Set<SongDTO> songDTOs = new HashSet<>();
        for(Song song:entity){
            songDTOs.add(new SongDTO(song));
        }
        return songDTOs;
    }
    private Set<PlaylistDTO> convertPlaylistToPlaylistDTO(Set<Playlist> entity){
        Set<PlaylistDTO> playlistDTOs = new HashSet<>();

        for(Playlist playlist:entity){
            playlistDTOs.add(new PlaylistDTO(playlist));
        }

        return playlistDTOs;
    }

}
