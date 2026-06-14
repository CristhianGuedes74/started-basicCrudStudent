package com.crud.basic.exceptions;

import org.springframework.http.HttpStatus;

public class StudentAlreadyExistException extends BusinessRuleException{
  private final HttpStatus status;

  public StudentAlreadyExistException(String message, HttpStatus status){
    super(message, status);
    this.status = status;
  }

  public StudentAlreadyExistException(){
    super("This Student already exist. Please try it again.", HttpStatus.CONFLICT);
    this.status = HttpStatus.CONFLICT;
  }
}
