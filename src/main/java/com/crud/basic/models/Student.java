package com.crud.basic.models;

import com.crud.basic.models.enums.StudentStates;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Student extends User{
  @Builder.Default
  private StudentStates academicState = StudentStates.ADDED;

  public void changeStudentStatus(StudentStates status){
    this.academicState = status;
  }
}
