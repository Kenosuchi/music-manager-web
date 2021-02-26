package com.springboot.restful.controller;

import com.springboot.restful.entities.Genre;
import com.springboot.restful.service.GenreService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllGenre() {
        return new ResponseEntity<ServiceResult>(genreService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(genreService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody Genre genre) {
        return new ResponseEntity<ServiceResult>(genreService.create(genre), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody Genre genre) {
        return new ResponseEntity<ServiceResult>(genreService.update(genre), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(genreService.delete(id), HttpStatus.OK);
    }
}
