package com.erzhiqianyi.yitian.security.model.bo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.*;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;

@Getter
@ToString
public class AuthTokenBo {

    //用户id
    private String uuid;

    //签发时间
    private Instant issueAt;

    //过期时间
    private Instant expirationAt;

    //其他数据
    Map<String, Object> claims;



    public AuthTokenBo(String uuid, long expiration, TemporalUnit unit, Map<String, Object> claims) {
        this.uuid = uuid;
        this.issueAt = Instant.now();
        this.expirationAt = issueAt.plus(expiration, unit);
        this.claims = null == claims ? new HashMap<>() : claims;
    }

    public String token(SignatureAlgorithm alg, String secret) {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(uuid)
                .setIssuedAt(Date.from(issueAt))
                .setExpiration(Date.from(expirationAt))
                .signWith(alg, secret)
                .compact();
    }

    public AuthTokenBo(String token, String secret) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
        this.uuid = claims.getSubject();
        this.issueAt = claims.getIssuedAt().toInstant();
        this.expirationAt = claims.getExpiration().toInstant();
        this.claims = claims;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthTokenBo)) return false;
        AuthTokenBo that = (AuthTokenBo) o;
        return getUuid().equals(that.getUuid()) &&
                getIssueAt().getLong(INSTANT_SECONDS) == that.getIssueAt().getLong(INSTANT_SECONDS) &&
                getExpirationAt().getLong(INSTANT_SECONDS) == that.getExpirationAt().getLong(INSTANT_SECONDS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, issueAt.getLong(INSTANT_SECONDS), expirationAt.getLong(INSTANT_SECONDS));
    }
}
