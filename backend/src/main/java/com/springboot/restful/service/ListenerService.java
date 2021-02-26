package com.springboot.restful.service;

import com.springboot.restful.dto.ListenerDTO;
import com.springboot.restful.dto.PlaylistDTO;
import com.springboot.restful.dto.SongDTO;
import com.springboot.restful.entities.Listener;
import com.springboot.restful.repository.AccountRepository;
import com.springboot.restful.repository.ListenerRepository;
import com.springboot.restful.utilities.ConvertDaoAndDto;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ListenerService implements ConvertDaoAndDto<Listener, ListenerDTO> {
    @Autowired
    private ListenerRepository listenerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PlaylistService playlistService;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        List<ListenerDTO> listenerDTOs = convertEntitiesToDTOs(listenerRepository.findAll());
        result.setData(listenerDTOs);
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Listener listener = listenerRepository.findById(id).orElse(null);
        assert listener != null;
        ListenerDTO listenerDTO = new ListenerDTO(listener);
        result.setData(listenerDTO);
        return result;
    }

    public ServiceResult findPlaylistOfUser(int id){
        ServiceResult result = new ServiceResult();
        Listener listener = listenerRepository.findById(id).orElse(null);
        if(listener!=null){
            Set<PlaylistDTO> playlistDTOs = (Set<PlaylistDTO>) playlistService.findPlaylistByListenerId(id).getData();
            result.setData(playlistDTOs);
        }
        else {
            result.setMessage("FAIL: Cannot get playlist of user "+id);
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    public ServiceResult findSongsInPlaylist(int playlistId){
        return playlistService.findSongsInPlaylist(playlistId);
    }



    public ServiceResult create(ListenerDTO listenerDTO) {
        ServiceResult result = new ServiceResult();
        Listener listener = convertDTOtoEntity(listenerDTO);
        result.setData(listenerRepository.save(listener));
        return result;
    }

    public ServiceResult update(ListenerDTO listenerDTO) {
        ServiceResult result = new ServiceResult();
        Listener listener = convertDTOtoEntity(listenerDTO);
        if (!listenerRepository.findById(listener.getListenerId()).isPresent()) {
            result.setMessage("Listener not found");
            result.setStatus(ServiceResult.Status.FAILED);
        } else {
            result.setData(listenerRepository.save(listener));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();
        Listener listener = listenerRepository.findById(id).orElse(null);
        if (listener==null) {
            result.setMessage("Listener "+listener.getListenerId()+" not found");
            result.setStatus(ServiceResult.Status.FAILED);
        } else {
            listenerRepository.delete(listener);
            result.setMessage("delete listener "+listener.getListenerId()+" success");
        }
        return result;
    }

    @Override
    public Listener convertDTOtoEntity(ListenerDTO listenerDTO) {
        Listener listener = new Listener();
        listener.setListenerId(listenerDTO.getListenerId());
        listener.setListenerName(listenerDTO.getListenerName());
        listener.setListenerAccount(accountRepository.findById(listenerDTO.getListenerAccountId()).orElse(null));
        return listener;
    }

    @Override
    public List<ListenerDTO> convertEntitiesToDTOs(List<Listener> entity) {
        List<ListenerDTO> listenerDTOs = new ArrayList<>();
        for(Listener listener:entity){
            listenerDTOs.add(new ListenerDTO(listener));
        }
        return listenerDTOs;
    }
}
