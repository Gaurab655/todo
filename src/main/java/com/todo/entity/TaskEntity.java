package com.todo.entity;

import com.todo.enums.TaskPriorityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}