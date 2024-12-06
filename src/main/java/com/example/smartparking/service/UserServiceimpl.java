package com.example.smartparking.service;

import com.example.smartparking.dto.ReservationDTO;
import com.example.smartparking.dto.UserDTO;
import com.example.smartparking.exception.UserNotFoundException;
import com.example.smartparking.model.User;
import com.example.smartparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO user) {
        User u = maptoUser(user);
         UserDTO p = maptoDTO(userRepository.save(u));
         return p;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @Override
    public void updateUser(Long id, User user) {
        User u =getUserById(id);

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setRegisteredVehicles(user.getRegisteredVehicles());
        userRepository.save(u);
    }
    public UserDTO maptoDTO(User user){
        UserDTO d =new UserDTO();
        d.setId(user.getId());
        d.setEmail(user.getEmail());
        d.setName(user.getName());
        d.setRegisteredVehicles(user.getRegisteredVehicles());
        d.setPhone(user.getPhone());

        return d;
    }
    public User maptoUser(UserDTO userDTO){
        User u = new User();
        u.setEmail(userDTO.getEmail());
        u.setName(userDTO.getName());
        u.setRegisteredVehicles(userDTO.getRegisteredVehicles());
        u.setPhone(userDTO.getPhone());
//        u.setReservations(userDTO.getReservations());
        return u;
    }
}

