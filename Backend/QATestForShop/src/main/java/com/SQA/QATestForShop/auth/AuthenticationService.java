package com.SQA.QATestForShop.auth;


import com.SQA.QATestForShop.User.Role;
import com.SQA.QATestForShop.User.User;
import com.SQA.QATestForShop.User.UserRepository;
import com.SQA.QATestForShop.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        Optional<User> user1 = userRepository.findByUserName(request.getEmail());
        if(user1.isPresent()){
            throw new RuntimeException("User already exists with the provided email.");
        }else {
            var user = User.builder()
                    .fullName(request.getFullName())
                    .email(request.getEmail().trim().toLowerCase())
                    .userName(request.getEmail().trim().toLowerCase())
                    .role(Role.USER)
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
            userRepository.save(user);

            var jwtToken = jwtService.generateToken(user);
            return  AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUserName(request.getUserName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(user.getId())
                .build();
    }
}
