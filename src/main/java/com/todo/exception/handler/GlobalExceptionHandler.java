package com.todo.exception.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.todo.builder.ServiceResponseBuilder;
import com.todo.exception.TodoException;
import com.todo.model.ApiResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TodoException.class)
    public ResponseEntity<ApiResponse> handleTodoException(TodoException e) {
        return ResponseEntity.status(e.getStatus())
                .body(ServiceResponseBuilder.buildUnknownFailedBuilder(e));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ServiceResponseBuilder.buildUnknownFailedBuilder(e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors()
                .stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(", "));
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(errorMessage);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ApiResponse apiResponse = new ApiResponse();
        if (e.getCause() instanceof InvalidFormatException ex) {
            Class<?> targetType = ex.getTargetType();

            if (targetType.isEnum()) {
                String validValues = Arrays.stream(targetType.getEnumConstants())
                        .map(object -> object.toString()).collect(Collectors.joining(", "));
                String errorMessage = String.format("Invalid value. Accepted values for '%s': [%s].", targetType.getSimpleName(), validValues);
                apiResponse.setMessage(errorMessage);
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
        }
        String errorMessage = "Enter valid Input \n" + e.getMessage();
        apiResponse.setMessage(errorMessage);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
