package com.springboot.restful.controller;

import com.springboot.restful.dto.PlaylistDTO;
import com.springboot.restful.service.PlaylistService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllPlaylist() {
        return new ResponseEntity<ServiceResult>(playlistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(playlistService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/listener/{id}")
    public ResponseEntity<ServiceResult> findPlaylistByListenerId(@PathVariable(name = "id") int listenerId){
        return new ResponseEntity<ServiceResult>(playlistService.findPlaylistByListenerId(listenerId),HttpStatus.OK);
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<ServiceResult> findSongsInPlaylist(@PathVariable(name = "id") int playlistId){
        return new ResponseEntity<ServiceResult>(playlistService.findSongsInPlaylist(playlistId),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody PlaylistDTO playlistDTO) {
        return new ResponseEntity<ServiceResult>(playlistService.create(playlistDTO), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody PlaylistDTO playlistDTO) {
        return new ResponseEntity<ServiceResult>(playlistService.update(playlistDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(playlistService.delete(id), HttpStatus.OK);
    }
}
