package com.springboot.restful.controller;

import com.springboot.restful.dto.ArtistDTO;
import com.springboot.restful.entities.Artist;
import com.springboot.restful.service.ArtistService;
import com.springboot.restful.utilities.ServiceResult;
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
    public ResponseEntity<ServiceResult> create(@RequestBody ArtistDTO artistDTO) {
        return new ResponseEntity<ServiceResult>(artistService.create(artistDTO), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody ArtistDTO artistDTO) {
        return new ResponseEntity<ServiceResult>(artistService.update(artistDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(artistService.delete(id), HttpStatus.OK);
    }
}
