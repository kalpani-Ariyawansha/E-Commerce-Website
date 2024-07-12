package com.SQA.QATestForShop.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserPersonalDetailsRepository userPersonalDetailsRepository;

    public void Profile(String id, UserPersonalDetailsRequest userPersonalDetails, MultipartFile userPhoto) throws IOException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
                UserPhoto userPhoto1 = UserPhoto.builder()
                        .photoType(userPhoto.getContentType())
                        .data(userPhoto.getBytes())
                        .name(userPhoto.getName())
                        .build();
                UserPersonalDetails userPersonalDetails1 = UserPersonalDetails.builder()
                        .userPhoto(userPhoto1)
                        .address(userPersonalDetails.getAddress())
                        .dob(userPersonalDetails.getDob())
                        .gender(userPersonalDetails.getGender())
                        .phoneNumber(userPersonalDetails.getPhoneNumber())
                        .build();
                userPersonalDetailsRepository.save(userPersonalDetails1);
                user.get().setUserPersonalDetails(userPersonalDetails1);
                userRepository.save(user.get());
        }

    }

    public UserPersonalDetails getProfile(String id) {

        Optional<User> user = userRepository.findById(id);

        return user.map(User::getUserPersonalDetails).orElse(null);
    }
}
