package com.example.Trello.Controller;

import com.example.Trello.Model.TaskGroup;
import com.example.Trello.Service.TaskGroupService;
import com.example.Trello.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskGroups")
public class TaskGroupController {
    @Autowired
    private TaskGroupService taskGroupService;

    @GetMapping //Lista todas as TaskGroups
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups() {
        return new ResponseEntity<>(taskGroupService.getAllTaskGroups(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //Busca pelo ID
    public ResponseEntity<TaskGroup> getTaskGroupById(@PathVariable Long id) {
        return new ResponseEntity<>(taskGroupService.findById(id), HttpStatus.OK);
    }

    @PostMapping //Cria uma nova TaskGroup
    public ResponseEntity<TaskGroup> createTaskGroup(@Valid @RequestBody TaskGroup taskGroup) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskGroupService.create(taskGroup));
    }

    @PostMapping("/save-all") // Salva
    public ResponseEntity<List<TaskGroup>> saveAllTaskGroups(@RequestBody @Valid List<TaskGroup> taskGroups) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskGroupService.saveAll(taskGroups));
    }

    @PutMapping("/{id}") //Atualiza a taskGroup existente
    public ResponseEntity<TaskGroup> updateTaskGroup(@PathVariable Long id, @Valid @RequestBody TaskGroup taskGroup) {
        return ResponseEntity.status(HttpStatus.OK).body(taskGroupService.update(id, taskGroup));
    }
}
