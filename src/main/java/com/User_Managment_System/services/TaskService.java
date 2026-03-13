package com.User_Managment_System.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User_Managment_System.model.Task;
import com.User_Managment_System.model.User;
import com.User_Managment_System.repository.TaskRepository;
import com.User_Managment_System.repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    public Task assignTask(Long userId, Task task) {

        User user = userRepo.findById(userId).orElseThrow();

        task.setUser(user);

        return taskRepo.save(task);
    }
}