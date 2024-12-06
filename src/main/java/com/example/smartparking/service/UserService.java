package com.example.smartparking.service;

import com.example.smartparking.dto.UserDTO;
import com.example.smartparking.model.User;

public interface UserService {
    UserDTO registerUser(UserDTO user);

    void updateUser(Long id, User user);

    User getUserById(Long id);
}
