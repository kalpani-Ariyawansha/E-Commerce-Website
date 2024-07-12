package com.SQA.QATestForShop.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPersonalDetailsRequest {
    private String address;
    private String phoneNumber;
    private LocalDate dob;
    private String gender;
    private UserPhoto userPhoto;
}
