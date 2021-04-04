package com.springboot.restful.dto;

import java.util.List;

public class ListDomainDTO<T> {
    private List<T> pagingDTO;
    private int size;

    public ListDomainDTO(List<T> dtos, int size) {
        this.pagingDTO = dtos;
        this.size = size;
    }

    public List<T> getDtos() {
        return pagingDTO;
    }

    public void setDtos(List<T> dtos) {
        this.pagingDTO = dtos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
