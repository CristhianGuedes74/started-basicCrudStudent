package com.crud.basic.exceptions;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

public class OperationTimeWindowException extends BusinessRuleException {    
  public OperationTimeWindowException(String message) {
      super(message, HttpStatus.FORBIDDEN);
  }
  
  public OperationTimeWindowException(LocalTime deadline) {
    super(String.format("Operation not allowed. Deadline was at %s. Please try again tomorrow.", deadline), 
      HttpStatus.FORBIDDEN);
  }

  public OperationTimeWindowException(){
    super("Operation not allowed.", HttpStatus.FORBIDDEN);
  }
}
