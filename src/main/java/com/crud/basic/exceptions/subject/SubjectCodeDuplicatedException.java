package com.crud.basic.exceptions.subject;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class SubjectCodeDuplicatedException extends BusinessRuleException{
  public SubjectCodeDuplicatedException(){
    super("Subject code duplicated. Please try it with another code.", HttpStatus.CONFLICT);
  }

  public SubjectCodeDuplicatedException(String message, HttpStatus status){
    super(message, status);
  }
}
