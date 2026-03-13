package com.User_Managment_System.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User_Managment_System.exception.ResourceNotFoundException;
import com.User_Managment_System.exception.UserAlreadyExistsException;
import com.User_Managment_System.model.Role;
import com.User_Managment_System.model.User;
import com.User_Managment_System.repository.RoleRepository;
import com.User_Managment_System.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public User createUser(User user){
        if(userRepo.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadyExistsException("User already exists with email: " + user.getEmail());
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){ return userRepo.findAll(); }

    public User getUserById(Long id){
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User updateUser(Long id, User userDetails){
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepo.save(user);
    }

    public void deleteUser(Long id){ userRepo.delete(getUserById(id)); }

    public User assignRole(Long userId, String roleName){
        User user = getUserById(userId);
        Role role = roleRepo.findByName(roleName);
        if(role == null) throw new ResourceNotFoundException("Role not found: " + roleName);
        user.getRoles().add(role);
        return userRepo.save(user);
    }
}