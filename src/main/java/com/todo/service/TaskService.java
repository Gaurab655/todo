package com.todo.service;

import com.todo.dto.requestDto.TaskRequestDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.model.Response;

public interface TaskService {
    ApiResponse addTask(TaskRequestDto taskRequestDto) throws TodoException;

    Response getTaskById(int id) throws TodoException;

    ApiResponse updateTaskById(int id, TaskRequestDto taskRequestDto) throws TodoException;

    ApiResponse deleteById(int id);

}
