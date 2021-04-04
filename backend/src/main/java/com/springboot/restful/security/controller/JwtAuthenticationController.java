package com.springboot.restful.security.controller;

import com.springboot.restful.dto.AccountDTO;
import com.springboot.restful.security.filter.JwtTokenUtil;
import com.springboot.restful.security.service.JwtUserDetailsService;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate/")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AccountDTO accountDTO,HttpServletResponse response) throws Exception {
        authenticate(accountDTO.getAccountUsername(), accountDTO.getAccountPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(accountDTO.getAccountUsername());

        String token = jwtTokenUtil.generateToken(userDetails);

        ServiceResult result = new ServiceResult();

        result.setStatus(ServiceResult.Status.FAILED);
        if(!"".equals(token)){
            result.setStatus(ServiceResult.Status.SUCCESS);
            result.setMessage("Set token success!");
        }
        Cookie cookie = new Cookie("access-token",token);
        cookie.setMaxAge((int)(0.5 * 24 * 60 * 60));
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok().body(result);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
