package com.crud.basic.models.DTOs.course;

import java.time.LocalDate;

import com.crud.basic.validations.IOnCreated;
import com.crud.basic.validations.IOnUpdated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record CourseRequestDTO(
  @NotBlank(groups = IOnCreated.class, message = "Course name cannot be empty. Try it again.")
  String name,

  @Null(groups = IOnCreated.class, message = "Cycle must be null on created method.")
  @NotBlank(groups = IOnUpdated.class,message = "Course academic cannot be null.")
  LocalDate cycle,

  @NotBlank(groups = IOnCreated.class, message = "Subject code cannot be empty. Try it again.")
  String subjectCode
) {}
