package com.javatechie.service;

import com.javatechie.dto.UserDTO;
import com.javatechie.response.MessageResponse;

public interface UserService {
    MessageResponse createUser(UserDTO userDTO);
}
