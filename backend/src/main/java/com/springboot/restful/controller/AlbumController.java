package com.springboot.restful.controller;

import com.springboot.restful.dto.AlbumDTO;
import com.springboot.restful.service.AlbumService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    
    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(albumService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable(name = "id") int albumId) {
        return new ResponseEntity<ServiceResult>(albumService.findById(albumId), HttpStatus.OK);
    }

    @GetMapping("/song-detail/{id}")
    public ResponseEntity<ServiceResult> findAlbumSongById(@PathVariable(name = "id") int albumId) {
        return new ResponseEntity<ServiceResult>(albumService.findSongsInAlbum(albumId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody AlbumDTO albumDTO) {
        return new ResponseEntity<ServiceResult>(albumService.create(albumDTO), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody AlbumDTO albumDTO) {
        return new ResponseEntity<ServiceResult>(albumService.update(albumDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable(name = "id") int albumId) {
        return new ResponseEntity<ServiceResult>(albumService.delete(albumId), HttpStatus.OK);
    }
}
