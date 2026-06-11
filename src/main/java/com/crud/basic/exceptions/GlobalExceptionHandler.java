package com.crud.basic.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(exception = StudentNotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handleNotFound(StudentNotFoundException ex){
    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.NOT_FOUND.value(),
      "NOT FOUND",
      ex.getMessage(),
      LocalDateTime.now()
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(exception = StudentAlreadyExistException.class)
  public ResponseEntity<ErrorResponseDTO> handlerDuplicated(StudentAlreadyExistException ex){
    ErrorResponseDTO error = new ErrorResponseDTO(
      HttpStatus.CONFLICT.value(),
      "CONFLIC",
      ex.getMessage(),
      LocalDateTime.now()
    );

    return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    // return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
  }

  @ExceptionHandler(exception = MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handlerValidations(MethodArgumentNotValidException ex){
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()
      .getFieldErrors()
      .forEach((e) -> 
        errors.put(e.getField(), e.getDefaultMessage())
    );

    return ResponseEntity.badRequest().body(errors);
  }
}
