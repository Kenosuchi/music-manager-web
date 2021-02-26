package com.springboot.restful.controller;

import com.springboot.restful.dto.ListenerDTO;
import com.springboot.restful.service.ListenerService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/listeners")
public class ListenerController {
    @Autowired
    private ListenerService listenerService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAll(){
        return new ResponseEntity<ServiceResult>(listenerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable(name="id")int listenerId){
        return new ResponseEntity<ServiceResult>(listenerService.findById(listenerId),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody ListenerDTO listenerDTO){
        return new ResponseEntity<ServiceResult>(listenerService.create(listenerDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody ListenerDTO listenerDTO){
        return new ResponseEntity<ServiceResult>(listenerService.update(listenerDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(int id){
        return new ResponseEntity<ServiceResult>(listenerService.delete(id),HttpStatus.OK);
    }
}
