package com.jordan.todoappproject.service;

import com.jordan.todoappproject.exceptions.ToDoExceptions;
import com.jordan.todoappproject.mapper.TaskInDTOToTask;
import com.jordan.todoappproject.persistence.entity.Task;
import com.jordan.todoappproject.persistence.entity.TaskStatus;
import com.jordan.todoappproject.persistence.repository.TaskRepository;
import com.jordan.todoappproject.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }


    public Task createTask(TaskInDTO taskInDTO) {

        Task task = mapper.map(taskInDTO);

        return this.taskRepository.save(task);
    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("{Task not found}", HttpStatus.NOT_FOUND);

        }
        this.taskRepository.markTaskAsFinished(id);
    }

    public void deleteTask(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("{Task not found}", HttpStatus.NOT_FOUND);

        }
        this.taskRepository.deleteById(id);
    }


}
