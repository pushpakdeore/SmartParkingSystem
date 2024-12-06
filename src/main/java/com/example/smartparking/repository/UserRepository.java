package com.example.smartparking.repository;

import com.example.smartparking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}





































//Optional<User> findByEmail(String email);