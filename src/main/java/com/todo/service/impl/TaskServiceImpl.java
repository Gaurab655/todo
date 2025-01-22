package com.todo.service.impl;

import com.todo.dto.TaskDto;
import com.todo.entity.CategoryEntity;
import com.todo.entity.TaskEntity;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.repository.CategoryRepo;
import com.todo.repository.TaskRepo;
import com.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;
    private final CategoryRepo categoryRepo;

    @Override
    public ApiResponse addTask(TaskDto taskDto) throws TodoException {
        TaskEntity taskEntity = this.modelMapper.map(taskDto, TaskEntity.class);
        CategoryEntity categoryEntity = categoryRepo.findById(taskDto.getCategory())
                .orElseThrow(() -> new TodoException("Category Id not found", HttpStatus.UNPROCESSABLE_ENTITY));

        taskEntity.setCategory(categoryEntity);
        taskRepo.save(taskEntity);

        return new ApiResponse("success");
    }


}
