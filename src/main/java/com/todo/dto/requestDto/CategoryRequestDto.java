package com.todo.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDto {
    @NotNull(message = "Insert name")
    private String name;

    @NotNull(message = "Enter Description")
    private String description;
}
