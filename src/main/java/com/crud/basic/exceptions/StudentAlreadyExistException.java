package com.crud.basic.exceptions;

public class StudentAlreadyExistException extends BusinessRuleException{
  public StudentAlreadyExistException(String message){
    super(message);
  }

  public StudentAlreadyExistException(){
  }
}
