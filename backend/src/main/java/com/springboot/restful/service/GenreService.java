package com.springboot.restful.service;

import com.springboot.restful.entities.Genre;
import com.springboot.restful.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(genreRepository.findAll());
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Genre genre = genreRepository.findById(id).orElse(null);
        result.setData(genre);
        return result;
    }

    public ServiceResult  create(Genre genre){
        ServiceResult result = new ServiceResult();
        result.setData(genreRepository.save(genre));
        return result;
    }

    public ServiceResult  update(Genre genre){
        ServiceResult result = new ServiceResult();
        if (!genreRepository.findById(genre.getGenreId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Genre Not Found");
        } else {
            result.setData(genreRepository.save(genre));
        }
        return result;
    }

    public ServiceResult  delete(int id){
        ServiceResult result = new ServiceResult();
        Genre genre = genreRepository.findById(id).orElse(null);
        if (genre == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Genre Not Found");
        } else {
            genreRepository.delete(genre);
            result.setMessage("success");
        }

        return result;
    }
}
