package com.example.demo.controller;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex) {
        List<String> stackTrace = convertStackTraceToArray(ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getError().getErrorMessage(),
                stackTrace
        );

        return ResponseEntity.status(ex.getError().getErrorStatus())
                .body(errorResponseDto);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex) {
        List<String> stackTrace = convertStackTraceToArray(ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getError().getErrorMessage(),
                stackTrace
        );

        return ResponseEntity.status(ex.getError().getErrorStatus())
                .body(errorResponseDto);
    }

    private List<String> convertStackTraceToArray(Exception ex) {
        return Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .toList();
    }
}
