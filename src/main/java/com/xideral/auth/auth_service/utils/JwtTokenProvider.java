package com.xideral.auth.auth_service.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String SECRET_KEY = "secret-key";
    private static final long EXPIRATION_TIME = 1000*60*60; //#1h


    public String generateToken(String username, String role) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public void validateToken(String token) {
        JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }
}
