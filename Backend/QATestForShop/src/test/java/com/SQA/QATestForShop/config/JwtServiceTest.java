package com.SQA.QATestForShop.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
    }

    @Test
    void testGenerateToken() {
        UserDetails userDetails = User.builder()
                .username("user@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
        assertTrue(token.startsWith("eyJ"));
    }

    @Test
    void testExtractUsername() {
        UserDetails userDetails = User.builder()
                .username("user@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        String token = jwtService.generateToken(userDetails);
        String username = jwtService.extractUsername(token);
        assertEquals("user@example.com", username);
    }

    @Test
    void testIsTokenValid() {
        UserDetails userDetails = User.builder()
                .username("user@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        String token = jwtService.generateToken(userDetails);
        assertTrue(jwtService.isTokenValid(token, userDetails));

        UserDetails incorrectUserDetails = User.builder()
                .username("wronguser@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        assertFalse(jwtService.isTokenValid(token, incorrectUserDetails));
    }

    @Test
    void testExtractAllClaims() {
        UserDetails userDetails = User.builder()
                .username("user@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        String token = jwtService.generateToken(userDetails);
        Claims claims = jwtService.extractAllClaims(token);

        assertNotNull(claims);
        assertEquals("user@example.com", claims.getSubject());
        assertNotNull(claims.getExpiration());
    }



    @Test
    void testPopulateAuthorities() {
        UserDetails userDetails = User.builder()
                .username("user@example.com")
                .password("password")
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();

        String authorities = jwtService.populateAuthorities(userDetails.getAuthorities());
        assertEquals("ROLE_USER", authorities);
    }
}
