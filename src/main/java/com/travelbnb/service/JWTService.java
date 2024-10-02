package com.travelbnb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.travelbnb.entity.AppUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry.duration}")
    private int expiryTime;

    private Algorithm algorithm;

    private final String USER_NAME = "username";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateToken(AppUser user){
        return JWT.create()
                .withClaim(USER_NAME,user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryTime))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String getUserName(String token) {
        DecodedJWT decodedJWT = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return decodedJWT.getClaim(USER_NAME).asString();
    }
}
