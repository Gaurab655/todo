package com.todo.service.impl;

import com.todo.dto.requestDto.CategoryRequestDto;
import com.todo.dto.responseDto.CategoryResponseDto;
import com.todo.entity.CategoryEntity;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.model.Response;
import com.todo.repository.CategoryRepo;
import com.todo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
        return new ApiResponse("Created Success");
    }

    @Override
    public Response getCategoryById(int id) throws TodoException {
        CategoryEntity category = categoryRepo.findById(id)
                .orElseThrow(() -> new TodoException("No category found for this id", HttpStatus.UNPROCESSABLE_ENTITY));
        CategoryResponseDto categoryResponseDto = this.modelMapper.map(category, CategoryResponseDto.class);
        return new Response(categoryResponseDto);

    }

    @Override
    public ApiResponse updateById(int id, CategoryRequestDto categoryRequestDto) throws TodoException {
        CategoryEntity category = categoryRepo.findById(id)
                .orElseThrow(() -> new TodoException("No category found for this id", HttpStatus.UNPROCESSABLE_ENTITY));
        modelMapper.map(categoryRequestDto, category);
        categoryRepo.save(category);
        return new ApiResponse("Updated Successfully");

    }

    @Override
    public ApiResponse deleteById(int id) throws TodoException {
        return null;
    }


}
