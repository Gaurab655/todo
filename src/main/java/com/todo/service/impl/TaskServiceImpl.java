package com.todo.service.impl;

import com.todo.builder.ServiceResponseBuilder;
import com.todo.dto.requestDto.TaskRequestDto;
import com.todo.dto.responseDto.TaskResponseDto;
import com.todo.entity.CategoryEntity;
import com.todo.entity.TaskEntity;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.repository.CategoryRepo;
import com.todo.repository.TaskRepo;
import com.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
                .orElseThrow(() -> new TodoException("Category Id not found"));

        taskEntity.setCategory(categoryEntity);

        taskRepo.save(taskEntity);
        return ServiceResponseBuilder.buildSuccessBuilder("Task Created Success");
    }

    @Override
    public ApiResponse getTaskById(int id) throws TodoException {
        TaskEntity taskEntity = taskRepo.findById(id)
                .orElseThrow(() -> new TodoException("Task not found with this id"));
        TaskResponseDto taskResponseDto = modelMapper.map(taskEntity, TaskResponseDto.class);
        return ServiceResponseBuilder.buildSuccessBuilder(taskResponseDto);
    }

    @Override
    public ApiResponse updateTaskById(int id, TaskRequestDto taskRequestDto) throws TodoException {
        TaskEntity taskEntity = taskRepo.findById(id)
                .orElseThrow(() -> new TodoException("No task found with this id"));
        modelMapper.map(taskRequestDto, taskEntity);
        taskRepo.save(taskEntity);
        return ServiceResponseBuilder.buildSuccessBuilder("Updated");
    }

    @Override
    public ApiResponse deleteById(int id) throws TodoException {
        TaskEntity taskEntity = taskRepo.findById(id).orElseThrow(()->new TodoException(" Task not found for that id"));
        taskRepo.delete(taskEntity);
        return ServiceResponseBuilder.buildSuccessBuilder("Deleted");
    }


}
