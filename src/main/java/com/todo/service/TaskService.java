package com.todo.service;

import com.todo.dto.TaskDto;
import com.todo.response.ApiResponse;

public interface TaskService {
     ApiResponse addTask(TaskDto taskDto);
}
