package com.example.Trello.Controller;

import com.example.Trello.Model.Board;
import com.example.Trello.Model.Task;
import com.example.Trello.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("all") //Lista todas as tasks
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //Busca pelo ID
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping //Cria uma nova task
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }
    @PostMapping("/save-all") //Salva
    public ResponseEntity<List<Task>> saveAllTasks(@RequestBody @Valid List<Task> tasks) {
        return new ResponseEntity<>(taskService.saveAll(tasks), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @Valid @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(id, task));
    }
}
