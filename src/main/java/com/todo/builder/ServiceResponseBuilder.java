package com.todo.builder;

import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceResponseBuilder {

    public static ApiResponse buildFailedBuilder(TodoException todoException) {
        return ApiResponse.builder()
                .message(todoException.getMessage())
                .success(false)
                .build();
    }

    public static ApiResponse buildSuccessBuilder(String message) {
        return ApiResponse.builder()
                .message(message)
                .success(true)
                .data(null)
                .build();
    }

    public static ApiResponse buildSuccessBuilder(String message, Object data) {
        return ApiResponse.builder()
                .message(message)
                .success(true)
                .data(data)
                .build();
    }

    public static ApiResponse buildSuccessBuilder(Object data) {
        return ApiResponse.builder()
                .success(true)
                .data(data)
                .build();
    }

    public static ApiResponse buildUnknownFailedBuilder(Exception e) {
        return ApiResponse.builder()
                .message(e.getMessage())
                .build();
    }
}
