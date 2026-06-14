package com.crud.basic.exceptions.student;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class StudentEmailDuplicatedException extends BusinessRuleException{
  public StudentEmailDuplicatedException(){
    super("Student Email duplicated. Please try it with another email.", HttpStatus.CONFLICT);
  }

  public StudentEmailDuplicatedException(String message, HttpStatus status){
    super(message, status);
  }
}
