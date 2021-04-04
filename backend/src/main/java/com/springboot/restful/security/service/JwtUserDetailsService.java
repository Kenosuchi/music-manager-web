package com.springboot.restful.security.service;

import com.springboot.restful.entities.Account;
import com.springboot.restful.service.AccountService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(accountService.checkUsername(username).getStatus() == ServiceResult.Status.SUCCESS){
            Account loadAccount = (Account) accountService.loadAccountByAccountName(username).getData();
            return new User(username,loadAccount.getAccountPassword(),loadAccount.getAuthorities());
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
