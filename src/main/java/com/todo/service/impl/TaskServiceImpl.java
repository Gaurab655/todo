package com.todo.service.impl;

import com.todo.dto.TaskDto;
import com.todo.entity.CategoryEntity;
import com.todo.entity.TaskEntity;
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
    private final CategoryEntity categoryEntity;
    private final CategoryRepo categoryRepo;

    @Override
    public String addTask(TaskDto taskDto) {
        TaskEntity taskEntity = this.modelMapper.map(taskDto, TaskEntity.class);

        taskRepo.save(taskEntity);
        return "Task returned success";
    }
}
