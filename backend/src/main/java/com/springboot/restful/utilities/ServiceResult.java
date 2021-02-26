package com.springboot.restful.utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResult {
    private Status status = Status.SUCCESS;
    private String message;
    private Object data;

    public enum Status{
        SUCCESS,FAILED;
    }
}
