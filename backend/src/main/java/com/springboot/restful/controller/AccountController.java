package com.springboot.restful.controller;

import com.springboot.restful.entities.Account;
import com.springboot.restful.service.AccountService;
import com.springboot.restful.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<ServiceResult> findAllAccount() {
        return new ResponseEntity<ServiceResult>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ServiceResult> create(@RequestBody Account account) {
        return new ResponseEntity<ServiceResult>(accountService.create(account), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ServiceResult> update(@RequestBody Account account) {
        return new ResponseEntity<ServiceResult>(accountService.update(account), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(accountService.delete(id), HttpStatus.OK);
    }
}
