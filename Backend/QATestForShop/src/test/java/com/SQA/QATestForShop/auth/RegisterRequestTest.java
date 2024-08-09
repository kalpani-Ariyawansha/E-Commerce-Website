package com.SQA.QATestForShop.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterRequestTest {

    @Test
    void testDefaultConstructor() {
        RegisterRequest request = new RegisterRequest();
        assertNull(request.getFullName());
        assertNull(request.getEmail());
        assertNull(request.getPassword());
    }

    @Test
    void testAllArgsConstructor() {
        RegisterRequest request = new RegisterRequest("John Doe", "john.doe@example.com", "password123");
        assertEquals("John Doe", request.getFullName());
        assertEquals("john.doe@example.com", request.getEmail());
        assertEquals("password123", request.getPassword());
    }

    @Test
    void testSettersAndGetters() {
        RegisterRequest request = new RegisterRequest();
        request.setFullName("Jane Doe");
        request.setEmail("jane.doe@example.com");
        request.setPassword("securepassword");

        assertEquals("Jane Doe", request.getFullName());
        assertEquals("jane.doe@example.com", request.getEmail());
        assertEquals("securepassword", request.getPassword());
    }

    @Test
    void testToString() {
        RegisterRequest request = new RegisterRequest("John Doe", "john.doe@example.com", "password123");
        String expectedString = "RegisterRequest(fullName=John Doe, email=john.doe@example.com, password=password123)";
        assertEquals(expectedString, request.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        RegisterRequest request1 = new RegisterRequest("John Doe", "john.doe@example.com", "password123");
        RegisterRequest request2 = new RegisterRequest("John Doe", "john.doe@example.com", "password123");

        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testBuilder() {
        RegisterRequest request = RegisterRequest.builder()
                .fullName("John Doe")
                .email("john.doe@example.com")
                .password("password123")
                .build();

        assertEquals("John Doe", request.getFullName());
        assertEquals("john.doe@example.com", request.getEmail());
        assertEquals("password123", request.getPassword());
    }
}
