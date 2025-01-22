package com.todo.service;

import com.todo.dto.TaskDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;

public interface TaskService {
     ApiResponse addTask(TaskDto taskDto) throws TodoException;
}
