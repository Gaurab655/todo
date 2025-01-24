package com.todo.service.impl;

import com.todo.dto.requestDto.TaskRequestDto;
import com.todo.dto.responseDto.TaskResponseDto;
import com.todo.entity.CategoryEntity;
import com.todo.entity.TaskEntity;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.model.Response;
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
    public ApiResponse addTask(TaskRequestDto taskRequestDto) throws TodoException {
        TaskEntity taskEntity = this.modelMapper.map(taskRequestDto, TaskEntity.class);
        CategoryEntity categoryEntity = categoryRepo.findById(taskRequestDto.getCategory())
                .orElseThrow(() -> new TodoException("Category Id not found", HttpStatus.UNPROCESSABLE_ENTITY));

        taskEntity.setCategory(categoryEntity);
        taskRepo.save(taskEntity);

        return new ApiResponse("success");
    }

    @Override
    public Response getTaskById(int id) throws TodoException {
        TaskEntity taskEntity = taskRepo.findById(id)
                .orElseThrow(() -> new TodoException("Task not found with this id", HttpStatus.UNPROCESSABLE_ENTITY));
        TaskResponseDto taskResponseDto = modelMapper.map(taskEntity, TaskResponseDto.class);
        return new Response(taskResponseDto);
    }

    @Override
    public ApiResponse updateTaskById(int id, TaskRequestDto taskRequestDto) throws TodoException {
        TaskEntity taskEntity = taskRepo.findById(id)
                .orElseThrow(() -> new TodoException("No task found with this id", HttpStatus.UNPROCESSABLE_ENTITY));

    }

    @Override
    public ApiResponse deleteById(int id) {
        return null;
    }


}
