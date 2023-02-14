package com.example.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<?> handle(BadRequest exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
