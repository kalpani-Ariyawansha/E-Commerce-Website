package com.SQA.QATestForShop.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationResponseTest {

    @Test
    public void testAuthenticationResponseCreation() {
        AuthenticationResponse response = new AuthenticationResponse("token123", "userId456");

        assertEquals("token123", response.getToken());
        assertEquals("userId456", response.getUserId());
    }

    @Test
    public void testBuilder() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token("builderToken")
                .userId("builderUserId")
                .build();

        assertEquals("builderToken", response.getToken());
        assertEquals("builderUserId", response.getUserId());
    }

    @Test
    public void testSettersAndGetters() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken("setToken");
        response.setUserId("setUserId");

        assertEquals("setToken", response.getToken());
        assertEquals("setUserId", response.getUserId());
    }

    @Test
    public void testNoArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse();

        assertNull(response.getToken());
        assertNull(response.getUserId());
    }

    @Test
    public void testAllArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse("fullToken", "fullUserId");

        assertEquals("fullToken", response.getToken());
        assertEquals("fullUserId", response.getUserId());
    }
}
