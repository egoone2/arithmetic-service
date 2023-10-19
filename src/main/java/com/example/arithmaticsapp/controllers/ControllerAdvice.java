package com.example.arithmaticsapp.controllers;

import com.example.arithmaticsapp.entity.response.ErrorResponse;
import com.example.arithmaticsapp.exceptions.ZeroDivisionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        String errorResponse = e.getBindingResult().getFieldError().getDefaultMessage();
        return new ErrorResponse(e.getStatusCode().toString(),  errorResponse,LocalDateTime.now());
    }

    @ExceptionHandler(ZeroDivisionException.class)
    public ErrorResponse handleException(ZeroDivisionException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.name(), e.getMessage(), LocalDateTime.now());
    }

}
