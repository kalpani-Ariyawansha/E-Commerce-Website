package com.SQA.QATestForShop.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserPhotoTest {

    @Test
    public void testUserPhotoBuilder() {
        byte[] imageData = new byte[]{1, 2, 3};

        UserPhoto userPhoto = UserPhoto.builder()
                .name("ProfilePicture")
                .photoType("jpg")
                .data(imageData)
                .build();

        assertNotNull(userPhoto);
        assertEquals("ProfilePicture", userPhoto.getName());
        assertEquals("jpg", userPhoto.getPhotoType());
        assertEquals(imageData, userPhoto.getData());
    }

    @Test
    public void testUserPhotoSettersAndGetters() {
        UserPhoto userPhoto = new UserPhoto();
        byte[] imageData = new byte[]{1, 2, 3};

        userPhoto.setName("ProfilePicture");
        userPhoto.setPhotoType("jpg");
        userPhoto.setData(imageData);

        assertEquals("ProfilePicture", userPhoto.getName());
        assertEquals("jpg", userPhoto.getPhotoType());
        assertEquals(imageData, userPhoto.getData());
    }

    @Test
    public void testUserPhotoAllArgsConstructor() {
        byte[] imageData = new byte[]{1, 2, 3};
        UserPhoto userPhoto = new UserPhoto("ProfilePicture", "jpg", imageData);

        assertEquals("ProfilePicture", userPhoto.getName());
        assertEquals("jpg", userPhoto.getPhotoType());
        assertEquals(imageData, userPhoto.getData());
    }

    @Test
    public void testUserPhotoNoArgsConstructor() {
        UserPhoto userPhoto = new UserPhoto();

        assertNotNull(userPhoto);
    }
}
