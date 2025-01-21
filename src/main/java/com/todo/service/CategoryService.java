package com.todo.service;

import com.todo.dto.CategoryDto;
import com.todo.response.ApiResponse;

public interface CategoryService {
    ApiResponse addCategory(CategoryDto categoryDto);
}
