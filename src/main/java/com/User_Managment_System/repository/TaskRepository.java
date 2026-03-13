package com.User_Managment_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.User_Managment_System.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}