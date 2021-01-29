package com.springboot.restful.controller;

import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.service.ServiceResult;
import com.springboot.restful.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllSong() {
        return new ResponseEntity<ServiceResult>(songService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(songService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<ServiceResult> findByName(@PathVariable(value = "title") String name) {
        return new ResponseEntity<ServiceResult>(songService.findSongByName(name), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody SongDTO songDTO) {
        return new ResponseEntity<ServiceResult>(songService.create(songDTO), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody SongDTO songDTO) {
        return new ResponseEntity<ServiceResult>(songService.update(songDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(songService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/delete-multiple")
    public ResponseEntity<ServiceResult> deleteMultipleSong(@RequestBody int[] intArr) {
        return new ResponseEntity<ServiceResult>(songService.deleteMultipleUser(intArr), HttpStatus.OK);
    }
}
