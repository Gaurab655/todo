package com.todo.service.impl;

import com.todo.dto.TaskDto;
import com.todo.entity.TaskEntity;
import com.todo.repository.TaskRepo;
import com.todo.response.ApiResponse;
import com.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse addTask(TaskDto taskDto) {
        TaskEntity taskEntity = this.modelMapper.map(taskDto, TaskEntity.class);
        taskRepo.save(taskEntity);
        return new ApiResponse("success",taskEntity);
    }
}
