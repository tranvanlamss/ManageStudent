package com.javatechie.controller;

import com.javatechie.dto.AuthRequest;
import com.javatechie.dto.RefreshTokenRequest;
import com.javatechie.entity.RefreshToken;
import com.javatechie.entity.UserEntity;
import com.javatechie.repository.UserRepository;
import com.javatechie.response.MessageResponse;
import com.javatechie.response.UserResponse;
import com.javatechie.service.JwtService;
import com.javatechie.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//
//            String token = jwtService.generateToken(authRequest.getUsername());
//            Optional<UserEntity> optionalUser = userRepository.findByUsername(authRequest.getUsername());
//            UserResponse userResponse = new UserResponse();
//            userResponse.setUser(optionalUser.get());
//            userResponse.setToken(token);
//            return ResponseEntity.ok(MessageResponse.ok(userResponse));
//
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.getUsername());
//            return JwtResponse.builder()
//                    .accessToken(jwtService.generateToken(authRequest.getUsername()))
//                    .token(refreshToken.getToken()).build();
            Optional<UserEntity> optionalUser = userRepository.findByUsername(authRequest.getUsername());
            UserResponse userResponse = new UserResponse();
            userResponse.setUser(optionalUser.get());
            userResponse.setAccessToken(jwtService.generateToken(authRequest.getUsername()));
            userResponse.setToken(refreshToken.getToken());
            return ResponseEntity.ok(MessageResponse.ok(userResponse));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<MessageResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return refreshTokenService.findByToken(refreshTokenRequest.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(userInfo -> {
                    String refreshToken = jwtService.generateToken(userInfo.getUsername());
                    Optional<UserEntity> optionalUser = userRepository.findByUsername(userInfo.getUsername());
                    UserResponse userResponse = new UserResponse();
                    userResponse.setUser(optionalUser.get());
                    userResponse.setRefreshToken(refreshToken);
                    userResponse.setToken(refreshTokenRequest.getToken());
                    return ResponseEntity.ok(MessageResponse.ok(userResponse));
                }).orElseThrow(() -> new RuntimeException(
                        "Refresh token is not in database!"));
    }

}
