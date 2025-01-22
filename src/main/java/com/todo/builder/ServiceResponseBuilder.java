package com.todo.builder;

import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceResponseBuilder {

    public static ApiResponse buildFailedBuilder(TodoException todoException) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(todoException.getMessage());
        return apiResponse;
    }

    public static ApiResponse buildUnknownFailedBuilder(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getMessage());
        return apiResponse;
    }
}
