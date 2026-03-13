package com.User_Managment_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.User_Managment_System.model.Task;
import com.User_Managment_System.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/assign/{userId}")
    public Task assignTask(@PathVariable Long userId,@RequestBody Task task){

        return taskService.assignTask(userId, task);
    }
}