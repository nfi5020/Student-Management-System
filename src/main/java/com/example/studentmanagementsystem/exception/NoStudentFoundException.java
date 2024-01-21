package com.example.studentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoStudentFoundException extends RuntimeException{
    public NoStudentFoundException(String message){
        super(message);
    }
}
