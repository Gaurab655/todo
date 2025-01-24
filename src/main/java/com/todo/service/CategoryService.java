package com.todo.service;

import com.todo.dto.requestDto.CategoryRequestDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.model.Response;

public interface CategoryService {
    ApiResponse addCategory(CategoryRequestDto categoryRequestDto);
     Response getCategoryById(int id) throws TodoException;
     ApiResponse updateById(int it,CategoryRequestDto categoryRequestDto) throws TodoException;
     ApiResponse deleteById(int id)throws TodoException;
}
