package com.todo.service.impl;

import com.todo.dto.CategoryDto;
import com.todo.entity.CategoryEntity;
import com.todo.repository.CategoryRepo;
import com.todo.response.ApiResponse;
import com.todo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse addCategory(CategoryDto categoryDto) {
        CategoryEntity category = this.modelMapper.map(categoryDto, CategoryEntity.class);
        categoryRepo.save(category);
        return new ApiResponse("Created ",category);
    }
}
