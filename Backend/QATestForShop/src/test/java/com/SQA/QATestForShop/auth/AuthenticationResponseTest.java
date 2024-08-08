package com.SQA.QATestForShop.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationResponseTest {

    @Test
    void testAllArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse("token123", "userId123");
        assertEquals("token123", response.getToken());
        assertEquals("userId123", response.getUserId());
    }

    @Test
    void testNoArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse();
        assertNull(response.getToken());
        assertNull(response.getUserId());
    }

    @Test
    void testBuilder() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token("token123")
                .userId("userId123")
                .build();

        assertEquals("token123", response.getToken());
        assertEquals("userId123", response.getUserId());
    }

    @Test
    void testSetters() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken("token123");
        response.setUserId("userId123");

        assertEquals("token123", response.getToken());
        assertEquals("userId123", response.getUserId());
    }

    @Test
    void testGetters() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token("token123")
                .userId("userId123")
                .build();

        assertEquals("token123", response.getToken());
        assertEquals("userId123", response.getUserId());
    }
}
