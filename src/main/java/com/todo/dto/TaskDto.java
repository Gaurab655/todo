package com.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private int id;

    @NotNull(message = "Enter title")
    private String title;

    @NotNull(message = "insert description")
    private String description;


}
