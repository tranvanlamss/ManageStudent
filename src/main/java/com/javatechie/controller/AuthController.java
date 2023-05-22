package com.javatechie.controller;

import com.javatechie.dto.AuthRequest;
import com.javatechie.dto.UserDTO;
import com.javatechie.entity.UserEntity;
import com.javatechie.repository.UserRepository;
import com.javatechie.response.MessageResponse;
import com.javatechie.response.UserResponse;
import com.javatechie.service.JwtService;
import com.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {

            String token = jwtService.generateToken(authRequest.getUsername());
            Optional<UserEntity> optionalUser = userRepository.findByUsername(authRequest.getUsername());
            UserResponse userResponse = new UserResponse();
            userResponse.setUser(optionalUser.get());
            userResponse.setToken(token);
            return ResponseEntity.ok(MessageResponse.ok(userResponse));

        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
