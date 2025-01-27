package com.todo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TodoException extends Exception {
    private final String message;
    private final HttpStatus status;

    public TodoException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public TodoException(String message) {
        super(message);
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
        this.message = "";
    }
}
