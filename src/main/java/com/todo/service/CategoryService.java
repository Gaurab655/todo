package com.todo.service;

import com.todo.dto.requestDto.CategoryRequestDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;

public interface CategoryService {
    ApiResponse addCategory(CategoryRequestDto categoryRequestDto);

    ApiResponse getCategoryById(int id) throws TodoException;

    ApiResponse updateById(int id, CategoryRequestDto categoryRequestDto) throws TodoException;

    ApiResponse deleteById(int id) throws TodoException;
}
