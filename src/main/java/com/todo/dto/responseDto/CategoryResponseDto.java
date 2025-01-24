package com.todo.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryResponseDto {
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
}
