package com.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    @NotNull(message = "Insert name")
    private String name;

    @NotNull(message = "Enter Description")
    private String description;
}
