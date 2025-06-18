package com.example.Trello.Service;

import com.example.Trello.Model.Board;
import com.example.Trello.Model.Task;
import com.example.Trello.Repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public Task create(Task tasks) {
        return taskRepo.save(tasks);
    }

    public List<Task> saveAll(List<Task> tasks) {
        return taskRepo.saveAll(tasks);
    }

    public List<Task> listAll() {
        return taskRepo.findAll();
    }

    public List<Task> getAllTasks() {
        return List.of();
    }

    public Task findById(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrado"));
    }

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task update(long id, @Valid Task task) {
        Task existing = taskRepo.findById(id).orElseThrow();
        existing.setName(task.getName());
        existing.setDescription(task.getDescription());
        return taskRepo.save(existing);
    }

}