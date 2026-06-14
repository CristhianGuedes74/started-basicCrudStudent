package com.crud.basic.exceptions;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends BusinessRuleException {
  private final HttpStatus status;

  public StudentNotFoundException(String message, HttpStatus status){
    super(message, status);
    this.status = status;
  }

  public StudentNotFoundException(){
    super("Student doesn't found. Please try it again.", HttpStatus.NOT_FOUND);
    this.status = HttpStatus.NOT_FOUND;
  }
}
