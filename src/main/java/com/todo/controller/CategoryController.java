package com.todo.controller;

import com.todo.dto.requestDto.CategoryRequestDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity<ApiResponse> addCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.addCategory(categoryRequestDto));
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable int id) throws TodoException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateById(@PathVariable int id, @RequestBody CategoryRequestDto categoryRequestDto) throws TodoException {
        return ResponseEntity.ok(categoryService.updateById(id, categoryRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable int id) throws TodoException {
        return ResponseEntity.ok(categoryService.deleteById(id));
    }
}
