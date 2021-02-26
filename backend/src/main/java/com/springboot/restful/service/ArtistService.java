package com.springboot.restful.service;

import com.springboot.restful.dto.ArtistDTO;
import com.springboot.restful.entities.Artist;
import com.springboot.restful.repository.AccountRepository;
import com.springboot.restful.repository.ArtistRepository;
import com.springboot.restful.utilities.ConvertDaoAndDto;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements ConvertDaoAndDto<Artist, ArtistDTO> {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AccountRepository accountRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        List<Artist> artists = artistRepository.findAll();
        List<ArtistDTO> artistDTOs = convertEntitiesToDTOs(artists);
        result.setData(artistDTOs);
        return result;
    }

    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Artist artist = artistRepository.findById(id).orElse(null);
        assert artist != null;
        ArtistDTO artistDTO = new ArtistDTO(artist);
        result.setData(artistDTO);
        return result;
    }

    public ServiceResult create(ArtistDTO artistDTO){
        ServiceResult result = new ServiceResult();
        Artist artist = convertDTOtoEntity(artistDTO);
        result.setData(artistRepository.save(artist));
        return result;
    }

    public ServiceResult update(ArtistDTO artistDTO){
        ServiceResult result = new ServiceResult();
        Artist artist = convertDTOtoEntity(artistDTO);
        if (!artistRepository.findById(artist.getArtistId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Artist Not Found");
        } else {
            result.setData(artistRepository.save(artist));
        }
        return result;
    }

    public ServiceResult delete(int id){
        ServiceResult result = new ServiceResult();
        Artist artist = artistRepository.findById(id).orElse(null);
        if (artist == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Artist Not Found");
        } else {
            artistRepository.delete(artist);
            result.setMessage("success");
        }

        return result;
    }


    @Override
    public Artist convertDTOtoEntity(ArtistDTO artistDTO) {
        Artist result = new Artist();
        result.setArtistAccount(accountRepository.findById(artistDTO.getArtistAccountId()).orElse(null));
        result.setArtistId(artistDTO.getArtistId());
        result.setArtistDescription(artistDTO.getArtistDescription());
        result.setArtistName(artistDTO.getArtistName());
        return result;
    }

    @Override
    public List<ArtistDTO> convertEntitiesToDTOs(List<Artist> entity) {
        List<ArtistDTO> result = new ArrayList<>();
        for(Artist artist :entity){
            result.add(new ArtistDTO(artist));
        }
        return result;
    }
}
