package com.SQA.QATestForShop.User;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserPersonalDetailsTest {

    @Test
    void testDefaultConstructor() {
        UserPersonalDetails details = new UserPersonalDetails();
        assertNull(details.getId());
        assertNull(details.getAddress());
        assertNull(details.getPhoneNumber());
        assertNull(details.getDob());
        assertNull(details.getGender());
        assertNull(details.getUserPhoto());
    }

    @Test
    void testAllArgsConstructor() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetails details = new UserPersonalDetails(
                "detailsId",
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        assertEquals("detailsId", details.getId());
        assertEquals("123 Main St", details.getAddress());
        assertEquals("555-1234", details.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), details.getDob());
        assertEquals("Male", details.getGender());
        assertEquals(userPhoto, details.getUserPhoto());
    }

    @Test
    void testSettersAndGetters() {
        UserPersonalDetails details = new UserPersonalDetails();
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        details.setId("detailsId");
        details.setAddress("123 Main St");
        details.setPhoneNumber("555-1234");
        details.setDob(LocalDate.of(1990, 1, 1));
        details.setGender("Male");
        details.setUserPhoto(userPhoto);

        assertEquals("detailsId", details.getId());
        assertEquals("123 Main St", details.getAddress());
        assertEquals("555-1234", details.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), details.getDob());
        assertEquals("Male", details.getGender());
        assertEquals(userPhoto, details.getUserPhoto());
    }

    @Test
    void testEqualsAndHashCode() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetails details1 = new UserPersonalDetails(
                "detailsId",
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        UserPersonalDetails details2 = new UserPersonalDetails(
                "detailsId",
                "123 Main St",
                "555-1234",
                LocalDate.of(1990, 1, 1),
                "Male",
                userPhoto
        );

        assertEquals(details1, details2);
        assertEquals(details1.hashCode(), details2.hashCode());
    }

    @Test
    void testBuilder() {
        UserPhoto userPhoto = new UserPhoto(
                "photoName",
                "image/jpeg",
                new byte[]{1, 2, 3}
        );

        UserPersonalDetails details = UserPersonalDetails.builder()
                .id("detailsId")
                .address("123 Main St")
                .phoneNumber("555-1234")
                .dob(LocalDate.of(1990, 1, 1))
                .gender("Male")
                .userPhoto(userPhoto)
                .build();

        assertEquals("detailsId", details.getId());
        assertEquals("123 Main St", details.getAddress());
        assertEquals("555-1234", details.getPhoneNumber());
        assertEquals(LocalDate.of(1990, 1, 1), details.getDob());
        assertEquals("Male", details.getGender());
        assertEquals(userPhoto, details.getUserPhoto());
    }
}
