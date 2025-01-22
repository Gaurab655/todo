package com.todo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TodoException extends Exception{
    private String message;
    private HttpStatus status;

    public TodoException(String message,HttpStatus status){
        super(message);
        this.message=message;
        this.status=status;
    }
}
