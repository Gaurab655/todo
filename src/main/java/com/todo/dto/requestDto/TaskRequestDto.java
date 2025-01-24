package com.todo.dto.requestDto;

import com.todo.enums.TaskPriorityEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    @NotNull(message = "Enter title")
    private String title;

    @NotNull(message = "Insert description")
    private String description;

    @NotNull(message = "Insert Priority")
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;

    @NotNull(message = "Insert Category")
    private Integer category;
}
