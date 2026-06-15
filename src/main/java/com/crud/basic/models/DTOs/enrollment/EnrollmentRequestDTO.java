package com.crud.basic.models.DTOs.enrollment;

import jakarta.validation.constraints.NotBlank;

public record EnrollmentRequestDTO(
  @NotBlank(message = "Student IC incorrect. Try it again.")
  String studentIc,

  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String courseName
) {}
