package com.crud.basic.exceptions.student;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class StudentNotFoundException extends BusinessRuleException {
  public StudentNotFoundException(String message, HttpStatus status){
    super(message, status);
  }

  public StudentNotFoundException(){
    super("Student doesn't found. Please try it again.", HttpStatus.NOT_FOUND);
  }
}
