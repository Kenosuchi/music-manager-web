package com.springboot.restful.controller;

import com.springboot.restful.entities.Role;
import com.springboot.restful.service.RoleService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllRole() {
        return new ResponseEntity<ServiceResult>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(roleService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody Role role) {
        return new ResponseEntity<ServiceResult>(roleService.create(role), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody Role role) {
        return new ResponseEntity<ServiceResult>(roleService.update(role), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(roleService.delete(id), HttpStatus.OK);
    }
}
