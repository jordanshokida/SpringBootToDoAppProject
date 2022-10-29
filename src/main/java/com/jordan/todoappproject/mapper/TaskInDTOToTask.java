package com.jordan.todoappproject.mapper;

import com.jordan.todoappproject.persistence.entity.Task;
import com.jordan.todoappproject.persistence.entity.TaskStatus;
import com.jordan.todoappproject.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEstimatedCompletionDate(in.getEstimatedCompletionDate());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }

}
