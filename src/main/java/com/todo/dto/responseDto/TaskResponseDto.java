package com.todo.dto.responseDto;

import com.todo.entity.CategoryEntity;
import com.todo.enums.TaskPriorityEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskResponseDto {
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private TaskPriorityEnum priority;
    private CategoryEntity category;
}
