package ru.otus.pro.psannikov.spring.boot.part2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> catchNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(new ErrorDto("RESOURCE_NOT_FOUND_EXCEPTION",exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
