package com.example.jojange.common;

import com.example.jojange.domain.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private static String secret = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";

    public String issueAccessToken(Member member) {
        long time = 1800000;
        return issueToken(member, time);
    }

    public String issueRefreshToken(Member member) {
        long time = 604800000; // 7일
        return issueToken(member, time);
    }

    private String issueToken(Member member, long time) {

        Date expiration = new Date(System.currentTimeMillis() + time);

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        String token = Jwts.builder()
                .claim("id", member.getId())
                .claim("email", member.getEmail())
                .setExpiration(expiration)
                .signWith(key)
                .compact();

        return token;
    }
}
