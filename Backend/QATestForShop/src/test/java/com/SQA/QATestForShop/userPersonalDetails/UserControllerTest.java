package com.SQA.QATestForShop.userPersonalDetails;


import com.SQA.QATestForShop.User.UserController;
import com.SQA.QATestForShop.User.UserPersonalDetails;
import com.SQA.QATestForShop.User.UserPersonalDetailsRequest;
import com.SQA.QATestForShop.User.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testProfileUpdate() throws Exception {
        String userDetails = "{\"address\":\"123 Street\", \"phoneNumber\":\"1234567890\", \"dob\":\"2000-01-01\", \"gender\":\"male\"}";
        MockMultipartFile photo = new MockMultipartFile("photo", "photo.jpg", MediaType.IMAGE_JPEG_VALUE, "photo content".getBytes());
        MockMultipartFile userDetailsPart = new MockMultipartFile("userDetails", "", "application/json", userDetails.getBytes());

        UserPersonalDetailsRequest userPersonalDetailsRequest = UserPersonalDetailsRequest.builder()
                .address("123 Street")
                .phoneNumber("1234567890")
                .dob(LocalDate.of(2000, 1, 1))
                .gender("male")
                .build();

        when(objectMapper.readValue(anyString(), eq(UserPersonalDetailsRequest.class))).thenReturn(userPersonalDetailsRequest);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/user/profile/{id}", "1")
                        .file(userDetailsPart)
                        .file(photo)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .with(request -> {
                            request.setMethod("PUT");
                            return request;
                        }))
                .andExpect(status().isOk());

        verify(userService, times(1)).Profile(eq("1"), eq(userPersonalDetailsRequest), eq(photo));
    }

    @Test
    void testGetProfile() throws Exception {
        UserPersonalDetails userPersonalDetails = UserPersonalDetails.builder()
                .id("1")
                .address("123 Street")
                .phoneNumber("1234567890")
                .dob(LocalDate.of(2000, 1, 1))
                .gender("male")
                .userPhoto(null)
                .build();

        when(userService.getProfile("1")).thenReturn(userPersonalDetails);

        mockMvc.perform(get("/api/v1/user/getProfile/{id}", "1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getProfile("1");
    }
}

