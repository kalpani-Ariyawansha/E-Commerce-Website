package com.SQA.QATestForShop.User;

import com.SQA.QATestForShop.payment.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getUsername());
        assertNull(user.getFullName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getRole());
        assertNull(user.getUserPersonalDetails());
        assertNull(user.getPayments());
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User(
                "userId",
                "userName",
                "fullName",
                "email@example.com",
                "password",
                Role.USER,
                null,
                List.of(new Payment())
        );

        assertEquals("userId", user.getId());
        assertEquals("userName", user.getUsername());
        assertEquals("fullName", user.getFullName());
        assertEquals("email@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Role.USER, user.getRole());
        assertNull(user.getUserPersonalDetails());
        assertNotNull(user.getPayments());
    }

    @Test
    void testSettersAndGetters() {
        User user = new User();
        user.setId("userId");
        user.setUserName("userName");
        user.setFullName("fullName");
        user.setEmail("email@example.com");
        user.setPassword("password");
        user.setRole(Role.ADMIN);
        user.setUserPersonalDetails(null);
        user.setPayments(List.of(new Payment()));

        assertEquals("userId", user.getId());
        assertEquals("userName", user.getUsername());
        assertEquals("fullName", user.getFullName());
        assertEquals("email@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Role.ADMIN, user.getRole());
        assertNull(user.getUserPersonalDetails());
        assertNotNull(user.getPayments());
    }

    @Test
    void testGetAuthorities() {
        User user = new User();
        user.setRole(Role.USER);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        assertNotNull(authorities);
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("USER")));
    }

    @Test
    void testUserDetailsMethods() {
        User user = new User(
                "userId",
                "userName",
                "fullName",
                "email@example.com",
                "password",
                Role.USER,
                null,
                List.of(new Payment())
        );

        assertEquals("password", user.getPassword());
        assertEquals("userName", user.getUsername());
        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isCredentialsNonExpired());
        assertTrue(user.isEnabled());
    }

    @Test
    void testToString() {
        User user = new User(
                "userId",
                "userName",
                "fullName",
                "email@example.com",
                "password",
                Role.USER,
                null,
                List.of(new Payment())
        );

        String expectedString = "User(id=userId, userName=userName, fullName=fullName, email=email@example.com, password=password, role=USER, userPersonalDetails=null, payments=[Payment(id=null, product=null, totalPrice=null, quantity=0)])";
        assertEquals(expectedString, user.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User(
                "userId",
                "userName",
                "fullName",
                "email@example.com",
                "password",
                Role.USER,
                null,
                List.of(new Payment())
        );

        User user2 = new User(
                "userId",
                "userName",
                "fullName",
                "email@example.com",
                "password",
                Role.USER,
                null,
                List.of(new Payment())
        );

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testBuilder() {
        User user = User.builder()
                .id("userId")
                .userName("userName")
                .fullName("fullName")
                .email("email@example.com")
                .password("password")
                .role(Role.ADMIN)
                .userPersonalDetails(null)
                .payments(List.of(new Payment()))
                .build();

        assertEquals("userId", user.getId());
        assertEquals("userName", user.getUsername());
        assertEquals("fullName", user.getFullName());
        assertEquals("email@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Role.ADMIN, user.getRole());
        assertNull(user.getUserPersonalDetails());
        assertNotNull(user.getPayments());
    }
}
