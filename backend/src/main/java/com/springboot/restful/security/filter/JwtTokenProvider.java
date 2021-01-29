//package com.springboot.restful.security.filter;
//
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.Assert;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.Map;
//
//public class JwtTokenProvider implements InitializingBean {
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        Assert.notNull(this.jwtSecret, "JWT secret can not be null");
//    }
//    public String generateJwt(String subject, Date dateIssue, Date expireDate, Map<String, Object> jwtBodies){
//        JwtBuilder jwtBuilder = Jwts.builder();
//        if(subject != null) {
//            jwtBuilder.setSubject(subject);
//        }
//        if(dateIssue !=null) {
//            jwtBuilder.setIssuedAt(dateIssue);
//        }
//        if(expireDate != null) {
//            jwtBuilder.setExpiration(expireDate);
//        }
//        if (jwtBodies != null) {
//            for (Map.Entry<String, Object> entry : jwtBodies.entrySet()) {
//                jwtBuilder.claim(entry.getKey(), entry.getValue());
//            }
//        }
//        try {
//            return jwtBuilder.signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes(StandardCharsets.UTF_8))
//                    .compact();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public Claims decodeJwtToken(String jwtToken) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8))
//                    .parseClaimsJws(jwtToken)
//                    .getBody();
//        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
//            throw ex;
//        }
//
//    }
//}
