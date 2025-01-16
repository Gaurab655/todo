package com.todo.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
}
