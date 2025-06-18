package com.example.Trello.Service;

import com.example.Trello.Model.Board;
import com.example.Trello.Model.TaskGroup;
import com.example.Trello.Repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupService {
    @Autowired
    private TaskGroupRepository taskGroupRepo;

    public TaskGroupService(TaskGroupRepository taskGroupRepo) {
        this.taskGroupRepo = taskGroupRepo;
    }

    public TaskGroup create(TaskGroup taskGroup) {
        return taskGroupRepo.save(taskGroup);
    }

    public List<TaskGroup> findAll() {
        return List.of();
    }
}
