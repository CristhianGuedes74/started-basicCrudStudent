package com.crud.basic.exceptions.course;

import org.springframework.http.HttpStatus;

import com.crud.basic.exceptions.BusinessRuleException;

public class CourseNotFoundException extends BusinessRuleException{
  public CourseNotFoundException(){
    super("Course not found. Please try it again.", HttpStatus.NOT_FOUND);
  }

  public CourseNotFoundException(String message, HttpStatus status){
    super(message, status);
  }
}
