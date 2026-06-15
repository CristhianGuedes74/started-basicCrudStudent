package com.crud.basic.models.DTOs.enrollment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EnrollmentResponseDTO(
  @Positive(message = "ID must be positive. Try it again.")
  Long id,

  @Positive(message = "ID must be positive. Try it again.")
  Long studentId,

  @NotBlank(message = "Student IC incorrect. Try it again.")
  String studentIc,

  @Positive(message = "ID must be positive. Try it again.")
  Long courseId,

  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String courseName,

  @Positive(message = "ID must be positive. Try it again.")
  Long subjectId,

  @NotBlank(message = "Subject code cannot be empty. Try it again.")
  String subjectCode
) {}
