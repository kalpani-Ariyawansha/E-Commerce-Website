package com.SQA.QATestForShop.userPersonalDetails;

import com.SQA.QATestForShop.User.*;
import com.SQA.QATestForShop.auth.AuthenticationService;
import com.SQA.QATestForShop.config.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserPersonalDetailsRepository userPersonalDetailsRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProfile() throws IOException, IOException {
        String userId = "123";
        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserPersonalDetailsRequest userPersonalDetailsRequest = new UserPersonalDetailsRequest();
        userPersonalDetailsRequest.setAddress("123 Street");
        userPersonalDetailsRequest.setDob(LocalDate.parse("2000-01-01"));
        userPersonalDetailsRequest.setGender("Male");
        userPersonalDetailsRequest.setPhoneNumber("1234567890");

        MultipartFile userPhoto = mock(MultipartFile.class);
        when(userPhoto.getContentType()).thenReturn("image/png");
        when(userPhoto.getBytes()).thenReturn(new byte[]{1, 2, 3});
        when(userPhoto.getName()).thenReturn("photo.png");


        userService.Profile(userId, userPersonalDetailsRequest, userPhoto);

        verify(userRepository, times(1)).findById(userId);
        verify(userPersonalDetailsRepository, times(1)).save(any(UserPersonalDetails.class));
        verify(userRepository, times(1)).save(any(User.class));

        ArgumentCaptor<UserPersonalDetails> userPersonalDetailsCaptor = ArgumentCaptor.forClass(UserPersonalDetails.class);
        verify(userPersonalDetailsRepository).save(userPersonalDetailsCaptor.capture());
        UserPersonalDetails savedUserPersonalDetails = userPersonalDetailsCaptor.getValue();

        assertNotNull(savedUserPersonalDetails);
        assertEquals("123 Street", savedUserPersonalDetails.getAddress());
        assertEquals(LocalDate.parse("2000-01-01"), savedUserPersonalDetails.getDob());
        assertEquals("Male", savedUserPersonalDetails.getGender());
        assertEquals("1234567890", savedUserPersonalDetails.getPhoneNumber());

        assertNotNull(savedUserPersonalDetails.getUserPhoto());
        assertEquals("image/png", savedUserPersonalDetails.getUserPhoto().getPhotoType());
        assertEquals("photo.png", savedUserPersonalDetails.getUserPhoto().getName());
    }

    @Test
    public void testGetProfile() {
        String userId = "123";
        User user = new User();
        UserPersonalDetails userPersonalDetails = new UserPersonalDetails();
        user.setUserPersonalDetails(userPersonalDetails);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserPersonalDetails result = userService.getProfile(userId);

        verify(userRepository, times(1)).findById(userId);
        assert(result != null);
    }

    @Test
    public void testGetProfile_UserNotFound() {
        String userId = "123";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        UserPersonalDetails result = userService.getProfile(userId);

        verify(userRepository, times(1)).findById(userId);
        assert(result == null);
    }
}
