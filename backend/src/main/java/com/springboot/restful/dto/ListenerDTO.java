package com.springboot.restful.dto;

import com.springboot.restful.entities.Listener;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListenerDTO {
    private int listenerId;
    private String listenerName;
    private int listenerAccountId;
    private int artistFollowed;

    public ListenerDTO() {
    }

    public ListenerDTO(Listener listener) {
        this.listenerId = listener.getListenerId();
        this.listenerName = listener.getListenerName();
        this.listenerAccountId = listener.getListenerAccount().getAccountId();
        this.artistFollowed = listener.getArtistFollowed().size();
    }
}
