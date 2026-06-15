package com.crud.basic.models.DTOs.enrollment;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EnrollmentResponseDetailDTO(
  @Positive(message = "ID must be positive. Try it again.")
  Long id,

  @Positive(message = "ID must be positive. Try it again.")
  Long studentId,

  @NotBlank(message = "Student IC incorrect. Try it again.")
  String studentIc,

  @NotBlank(message = "Student name incorrect. Try it again.")
  String studentName,

  @NotBlank(message = "Student academic state cannot be empty. Try it again.")
  String studentAcademicState,

  @Positive(message = "ID must be positive. Try it again.")
  Long courseId,

  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String courseName,

  @NotNull(message = "Course academic cannot be null.")
  LocalDate courseCycle,

  @Positive(message = "ID must be positive. Try it again.")
  Long subjectId,

  @NotBlank(message = "Subject code cannot be empty. Try it again.")
  String subjectCode
) {}
