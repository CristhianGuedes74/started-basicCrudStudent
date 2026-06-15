package com.crud.basic.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

<<<<<<< Updated upstream
@RestControllerAdvice
public class GlobalExceptionHandler {
  // student not found
=======
import com.crud.basic.exceptions.course.CourseNotFoundException;
import com.crud.basic.exceptions.student.StudentEmailDuplicatedException;
import com.crud.basic.exceptions.student.StudentIcDuplicatedException;
import com.crud.basic.exceptions.student.StudentNotFoundException;
import com.crud.basic.exceptions.subject.SubjectCodeDuplicatedException;
import com.crud.basic.exceptions.subject.SubjectNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  //? GLOBAL
  // Handler @Valid error
  @ExceptionHandler(exception = MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handlerValidations(MethodArgumentNotValidException ex, WebRequest req){
    Map<String, String> errors = new HashMap<>();
  
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
  
    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST.value(),
      HttpStatus.BAD_REQUEST.name(),
      "Validation Error.",
      req.getDescription(false).replace("uri=", ""),
      errors
    );
  
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(exception = BusinessRuleException.class)
  public ResponseEntity<ErrorResponseDTO> handlerBusinessException(BusinessRuleException ex, WebRequest req){
    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST.value(),
      HttpStatus.BAD_REQUEST.name(),
      ex.getMessage(),
      req.getDescription(false).replace("uri=", ""),
      null
    );

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  //? STUDENT
  // Student not found
>>>>>>> Stashed changes
  @ExceptionHandler(exception = StudentNotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handleNotFound(StudentNotFoundException ex, WebRequest req){
    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.NOT_FOUND.value(),
      HttpStatus.NOT_FOUND.name(),
      ex.getMessage(),
      req.getDescription(false).replace("uri=", ""),
      null
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  // student already exist
  @ExceptionHandler(exception = StudentAlreadyExistException.class)
  public ResponseEntity<ErrorResponseDTO> handlerDuplicated(StudentAlreadyExistException ex, WebRequest req){
    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.CONFLICT.value(),
      HttpStatus.CONFLICT.name(),
      ex.getMessage(),
      req.getDescription(false).replace("uri=", ""),
      null
    );

    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }

  // Handler @Valid error
  @ExceptionHandler(exception = MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handlerValidations(MethodArgumentNotValidException ex, WebRequest req){
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST.value(),
      HttpStatus.BAD_REQUEST.name(),
      "Validation Error.",
      req.getDescription(false).replace("uri=", ""),
      errors
    );

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  //? Course
  // Course not found
  public ResponseEntity<ErrorResponseDTO> handlerNotFound(CourseNotFoundException ex, WebRequest req){
    ErrorResponseDTO error = new ErrorResponseDTO(
      LocalDateTime.now(),
      HttpStatus.NOT_FOUND.value(),
      HttpStatus.NOT_FOUND.name(),
      ex.getMessage(),
      req.getDescription(false).replace("uri=", ""),
      null
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
