package com.todo.service.impl;

import com.todo.builder.ServiceResponseBuilder;
import com.todo.dto.requestDto.CategoryRequestDto;
import com.todo.dto.responseDto.CategoryResponseDto;
import com.todo.entity.CategoryEntity;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.repository.CategoryRepo;
import com.todo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse addCategory(CategoryRequestDto categoryRequestDto) {
        CategoryEntity category = this.modelMapper.map(categoryRequestDto, CategoryEntity.class);
        categoryRepo.save(category);
        return ServiceResponseBuilder.buildSuccessBuilder("Category created successfully");
    }

    @Override
    public ApiResponse getCategoryById(int id) throws TodoException {
        CategoryEntity category = categoryRepo.findById(id)
                .orElseThrow(() -> new TodoException("No category found for this id"));
        CategoryResponseDto categoryResponseDto = this.modelMapper.map(category, CategoryResponseDto.class);
        return ServiceResponseBuilder.buildSuccessBuilder("", categoryResponseDto);

    }

    @Override
    public ApiResponse updateById(int id, CategoryRequestDto categoryRequestDto) throws TodoException {
        CategoryEntity category = categoryRepo.findById(id).orElseThrow(() -> new TodoException("No category found for this id"));
        modelMapper.map(categoryRequestDto, category);
        categoryRepo.save(category);
        return ServiceResponseBuilder.buildSuccessBuilder("Updated");

    }

    @Override
    public ApiResponse deleteById(int id) throws TodoException {
        CategoryEntity category = categoryRepo.findById(id).orElseThrow(() -> new TodoException("Task not found for this id"));
        categoryRepo.delete(category);
        return ServiceResponseBuilder.buildSuccessBuilder("Deleted success");
    }


}
