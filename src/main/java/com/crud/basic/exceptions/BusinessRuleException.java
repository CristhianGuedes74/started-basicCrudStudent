package com.crud.basic.exceptions;

public class BusinessRuleException extends RuntimeException{
  public BusinessRuleException(String message){
    super(message);
  }

  public BusinessRuleException(){
    // super(message);
  }
}
