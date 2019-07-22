package com.erzhiqianyi.blog.model.bo.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;

@Getter
public class AuthUserBo {
    private String name;
    private Instant issueAt;
    private Instant expirationAt;

    public AuthUserBo(String name, long expiration, TemporalUnit unit) {
        this.name = name;
        Instant now = Instant.now();
        this.issueAt = now;
        this.expirationAt = now.plus(expiration, unit);
    }

    public AuthUserBo(String token, String secret) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
        this.name = claims.getSubject();
        this.issueAt = claims.getIssuedAt().toInstant();
        this.expirationAt = claims.getExpiration().toInstant();
    }

    public String token(SignatureAlgorithm alg,String secret) {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.builder()
                .setSubject(name)
                .setIssuedAt(Date.from(issueAt))
                .setExpiration(Date.from(expirationAt))
                .signWith(alg, secret)
                .compact();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthUserBo)) return false;
        AuthUserBo that = (AuthUserBo) o;
        return getName().equals(that.getName()) &&
                getIssueAt().getLong(INSTANT_SECONDS) == that.getIssueAt().getLong(INSTANT_SECONDS) &&
                getExpirationAt().getLong(INSTANT_SECONDS) == that.getExpirationAt().getLong(INSTANT_SECONDS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIssueAt().getLong(INSTANT_SECONDS), getExpirationAt().getLong(INSTANT_SECONDS));
    }
}
