package com.springboot.restful.controller;

import com.springboot.restful.entities.Artist;
import com.springboot.restful.service.ArtistService;
import com.springboot.restful.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllArtist() {
        return new ResponseEntity<ServiceResult>(artistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(artistService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody Artist artist) {
        return new ResponseEntity<ServiceResult>(artistService.create(artist), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody Artist artist) {
        return new ResponseEntity<ServiceResult>(artistService.update(artist), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(artistService.delete(id), HttpStatus.OK);
    }
}
