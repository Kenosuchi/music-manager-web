package com.springboot.restful.service;

import com.springboot.restful.entities.Artist;
import com.springboot.restful.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(artistRepository.findAll());
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Artist artist = artistRepository.findById(id).orElse(null);
        result.setData(artist);
        return result;
    }

    public ServiceResult  create(Artist artist){
        ServiceResult result = new ServiceResult();
        result.setData(artistRepository.save(artist));
        return result;
    }

    public ServiceResult  update(Artist artist){
        ServiceResult result = new ServiceResult();
        if (!artistRepository.findById(artist.getArtistId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            result.setData(artistRepository.save(artist));
        }
        return result;
    }

    public ServiceResult  delete(int id){
        ServiceResult result = new ServiceResult();
        Artist artist = artistRepository.findById(id).orElse(null);
        if (artist == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            artistRepository.delete(artist);
            result.setMessage("success");
        }

        return result;
    }


}
