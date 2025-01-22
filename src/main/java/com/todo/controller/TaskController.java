package com.todo.controller;

import com.todo.dto.TaskDto;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import com.todo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add-task")
    public ResponseEntity<ApiResponse> addTask(@Valid @RequestBody TaskDto taskDto) throws TodoException {
        return new ResponseEntity<>(taskService.addTask(taskDto), HttpStatus.OK);
    }
}
