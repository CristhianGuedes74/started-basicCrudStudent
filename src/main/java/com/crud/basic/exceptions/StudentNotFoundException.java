package com.crud.basic.exceptions;

public class StudentNotFoundException extends BusinessRuleException {
  public StudentNotFoundException(String message){
    super(message);
  }

  public StudentNotFoundException(){
    // super(message);
  }
}
