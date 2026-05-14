package com.wms.warehouse_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation exception handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(
            MethodArgumentNotValidException ex)
    {

        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return new ResponseEntity<>(
                errorMessage,
                HttpStatus.BAD_REQUEST
        );
    }

    // General exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex)
    {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}