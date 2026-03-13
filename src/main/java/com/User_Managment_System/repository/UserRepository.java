package com.User_Managment_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User_Managment_System.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}