package com.SQA.QATestForShop.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.annotation.Retention;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PutMapping("/profile/{id}")
    public ResponseEntity<?> profile(
            @RequestPart("userDetails") String userDetails,
            @RequestPart("photo") MultipartFile photo,
            @PathVariable String id
            ) throws JsonProcessingException {
                UserPersonalDetailsRequest userPersonalDetails = objectMapper.readValue(userDetails,UserPersonalDetailsRequest.class);
        try{
            userService.Profile(id,userPersonalDetails,photo);
            return ResponseEntity.ok("Updated");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getProfile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable String id){
        try{
            UserPersonalDetails userPersonalDetails = userService.getProfile(id);
            return ResponseEntity.ok(userPersonalDetails);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
