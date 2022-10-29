package com.jordan.todoappproject.controller;

import com.jordan.todoappproject.persistence.entity.Task;
import com.jordan.todoappproject.persistence.entity.TaskStatus;
import com.jordan.todoappproject.service.TaskService;
import com.jordan.todoappproject.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
