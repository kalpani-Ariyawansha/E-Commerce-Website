package com.SQA.QATestForShop.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationRequestTest {

    @Test
    public void testAuthenticationRequestCreation() {
        AuthenticationRequest request = new AuthenticationRequest("testUser", "testPassword");

        assertEquals("testUser", request.getUserName());
        assertEquals("testPassword", request.getPassword());
    }

    @Test
    public void testBuilder() {
        AuthenticationRequest request = AuthenticationRequest.builder()
                .userName("builderUser")
                .password("builderPassword")
                .build();

        assertEquals("builderUser", request.getUserName());
        assertEquals("builderPassword", request.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUserName("newUser");
        request.setPassword("newPassword");

        assertEquals("newUser", request.getUserName());
        assertEquals("newPassword", request.getPassword());
    }

    @Test
    public void testNoArgsConstructor() {
        AuthenticationRequest request = new AuthenticationRequest();

        assertNull(request.getUserName());
        assertNull(request.getPassword());
    }

    @Test
    public void testAllArgsConstructor() {
        AuthenticationRequest request = new AuthenticationRequest("constructorUser", "constructorPassword");

        assertEquals("constructorUser", request.getUserName());
        assertEquals("constructorPassword", request.getPassword());
    }

    @Test
    public void testToString() {
        AuthenticationRequest request = new AuthenticationRequest("testUser", "testPassword");

        String expectedToString = "AuthenticationRequest(userName=testUser, password=testPassword)";
        assertEquals(expectedToString, request.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        AuthenticationRequest request1 = new AuthenticationRequest("user1", "password1");
        AuthenticationRequest request2 = new AuthenticationRequest("user1", "password1");
        AuthenticationRequest request3 = new AuthenticationRequest("user2", "password2");

        assertEquals(request1, request2);
        assertNotEquals(request1, request3);


        assertEquals(request1.hashCode(), request2.hashCode());
        assertNotEquals(request1.hashCode(), request3.hashCode());
    }
}
