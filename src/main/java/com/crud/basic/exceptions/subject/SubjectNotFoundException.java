package com.crud.basic.exceptions.subject;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class SubjectNotFoundException extends BusinessRuleException{
  public SubjectNotFoundException(){
    super("Subject not found. Try it again.", HttpStatus.NOT_FOUND);
  }

  public SubjectNotFoundException(String message, HttpStatus status){
    super(message, status);
  }
}
