package com.javatechie.service.Impl;

import com.javatechie.dto.UserDTO;
import com.javatechie.entity.UserEntity;
import com.javatechie.exception.InputInvalidException;
import com.javatechie.repository.UserRepository;
import com.javatechie.response.MessageResponse;
import com.javatechie.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MessageResponse createUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(userDTO.getRoles());

        String password = userDTO.getPassword();
        String rePassword = userDTO.getRePassword();

        if (!password.equals(rePassword)) {
//            return MessageResponse.error(ErrorCodesEnum.PASSWORD_AND_RETYPE_PASSWORD_NOT_MATCH);
            throw new InputInvalidException("Not equals");
        }
        userRepository.save(user);
        return MessageResponse.ok(user);
    }

}
