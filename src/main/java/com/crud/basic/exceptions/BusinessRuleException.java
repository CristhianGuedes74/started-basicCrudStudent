package com.crud.basic.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessRuleException extends RuntimeException{
  private final HttpStatus status;

  public BusinessRuleException(String message, HttpStatus status){
    super(message);
    this.status = status;
  }

  public BusinessRuleException(){
    super("An unexpected Error ocurred. Please try it again.");
    this.status = HttpStatus.BAD_REQUEST;
  }
}
