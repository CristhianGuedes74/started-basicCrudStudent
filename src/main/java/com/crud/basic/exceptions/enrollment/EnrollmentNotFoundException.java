package com.crud.basic.exceptions.enrollment;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class EnrollmentNotFoundException extends BusinessRuleException{
  public EnrollmentNotFoundException(){
    super("Enrollment not found. Please try it again.", HttpStatus.NOT_FOUND);
  }

  public EnrollmentNotFoundException(String message, HttpStatus status){
    super(message, status);
  }

  public EnrollmentNotFoundException(String message){
    super(message, HttpStatus.NOT_FOUND);
  }
}
