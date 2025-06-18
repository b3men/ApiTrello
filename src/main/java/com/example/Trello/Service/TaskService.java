package com.example.Trello.Service;

import com.example.Trello.Model.Board;
import com.example.Trello.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task saveAll(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> findAll() {
        return List.of();
    }


    public List<Task> getAllTasks() {

    }
}