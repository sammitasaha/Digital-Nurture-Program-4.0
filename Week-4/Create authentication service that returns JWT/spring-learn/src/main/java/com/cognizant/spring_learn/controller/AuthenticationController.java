package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkey123"; // Store in config for real apps

    @RequestMapping("/authenticate")
    public Map<String, String> authenticate(HttpServletRequest request) {
        LOGGER.debug("START - /authenticate");

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decodedCredentials = new String(decodedBytes);

        String[] credentials = decodedCredentials.split(":", 2);
        if (credentials.length != 2) {
            throw new RuntimeException("Invalid Authorization format");
        }

        String username = credentials[0];
        String password = credentials[1];

        if (!username.equals("user") || !password.equals("pwd")) {
            throw new RuntimeException("Invalid Credentials");
        }

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 mins
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.debug("END - /authenticate");
        return response;
    }
}
