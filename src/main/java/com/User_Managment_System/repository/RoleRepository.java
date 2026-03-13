package com.User_Managment_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User_Managment_System.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}