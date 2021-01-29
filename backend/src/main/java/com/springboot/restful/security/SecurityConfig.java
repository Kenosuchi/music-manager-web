//package com.springboot.restful.security;
//
//import com.springboot.restful.entities.Account;
//import com.springboot.restful.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AccountService accountService;
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        List<Account> accounts = (List<Account>) accountService.findAll().getData();
//        for(Account account :accounts) {
//            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
//                    .withUser(account.getAccountUsername()).password(account.getAccountPassword()).roles(account.getAccountRole().getRoleName());
//        }
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/**").permitAll();
//    }
//}
