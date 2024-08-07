package com.SQA.QATestForShop.User;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserPersonalDetailsRequestTest {

    @Test
    void testDefaultConstructor() {
        UserPersonalDetailsRequest request = new UserPersonalDetailsRequest();
        assertNull(request.getAddress());
        assertNull(request.getPhoneNumber());
        assertNull(request.getDob());
        assertNull(request.getGender());
        assertNull(request.getUserPhoto());
    }

    @Test
    void testAllArgsConstructor() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetailsRequest request = new UserPersonalDetailsRequest(
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        assertEquals("123 Main St", request.getAddress());
        assertEquals("555-1234", request.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), request.getDob());
        assertEquals("Male", request.getGender());
        assertEquals(userPhoto, request.getUserPhoto());
    }

    @Test
    void testSettersAndGetters() {
        UserPersonalDetailsRequest request = new UserPersonalDetailsRequest();
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        request.setAddress("123 Main St");
        request.setPhoneNumber("555-1234");
        request.setDob(LocalDate.of(1990, 1, 1));
        request.setGender("Male");
        request.setUserPhoto(userPhoto);

        assertEquals("123 Main St", request.getAddress());
        assertEquals("555-1234", request.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), request.getDob());
        assertEquals("Male", request.getGender());
        assertEquals(userPhoto, request.getUserPhoto());
    }

    @Test
    void testEqualsAndHashCode() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetailsRequest request1 = new UserPersonalDetailsRequest(
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        UserPersonalDetailsRequest request2 = new UserPersonalDetailsRequest(
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testBuilder() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetailsRequest request = UserPersonalDetailsRequest.builder()
                .address("123 Main St")
                .phoneNumber("555-1234")
                .dob(LocalDate.of(1990, 1, 1))
                .gender("Male")
                .userPhoto(userPhoto)
                .build();

        assertEquals("123 Main St", request.getAddress());
        assertEquals("555-1234", request.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), request.getDob());
        assertEquals("Male", request.getGender());
        assertEquals(userPhoto, request.getUserPhoto());
    }
}
