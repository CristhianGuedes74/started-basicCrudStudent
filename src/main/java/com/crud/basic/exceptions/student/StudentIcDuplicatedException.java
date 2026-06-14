package com.crud.basic.exceptions.student;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class StudentIcDuplicatedException extends BusinessRuleException{
  public StudentIcDuplicatedException(String message, HttpStatus status){
    super(message, status);
  }

  public StudentIcDuplicatedException(){
    super("Student IC duplicated. Please try it with another IC.", HttpStatus.CONFLICT);
  }
}
