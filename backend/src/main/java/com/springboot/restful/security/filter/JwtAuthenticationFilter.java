//package com.springboot.restful.security.filter;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final static String TOKEN_HEADER = "access-token";
//    private final AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String token = request.getHeader(TOKEN_HEADER);
//
//        if (token != null) {
//            JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
//            Authentication authentication = authenticationManager.authenticate(jwtAuthenticationToken);
//            if(authentication!=null){
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request,response);
//    }
//}
