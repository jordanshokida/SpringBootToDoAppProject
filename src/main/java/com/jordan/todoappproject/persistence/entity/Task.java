package com.jordan.todoappproject.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime estimatedCompletionDate;
    private boolean isFinished;
    private TaskStatus taskStatus;
}
