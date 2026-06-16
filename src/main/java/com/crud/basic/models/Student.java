package com.crud.basic.models;

import java.util.List;

import com.crud.basic.models.enums.StudentStates;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Enrollment> enrollments;

  public void changeStudentStatus(StudentStates status){
    this.academicState = status;
  }
}
