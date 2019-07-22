package com.erzhiqianyi.blog.model.bo.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Base64;
import java.util.Date;

@Getter
public class AuthUserBo {
    private String name;
    private Date issueAt;
    private Date expirationAt;

    public AuthUserBo(String name, long expiration, TemporalUnit unit) {
        this.name = name;
        Instant now = Instant.now();
        this.issueAt = Date.from(now);
        this.expirationAt = Date.from(now.plus(expiration, unit));
    }

    public AuthUserBo(String token, String secret) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }

    public String token(String secret) {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.builder()
                .setSubject(name)
                .setIssuer(name)
                .setIssuedAt(issueAt)
                .setExpiration(expirationAt)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


}
