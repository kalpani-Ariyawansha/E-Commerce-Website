package com.SQA.QATestForShop.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PersonalDetails")
public class UserPersonalDetails {
    @Id
    private String id;
    private String address;
    private String phoneNumber;
    private LocalDate dob;
    private String gender;
    private UserPhoto userPhoto;
}
