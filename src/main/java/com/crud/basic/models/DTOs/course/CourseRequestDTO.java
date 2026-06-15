package com.crud.basic.models.DTOs.course;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDTO(
  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String name,

  @NotBlank(message = "Subject code cannot be empty. Try it again.")
  String subjectCode
) {}
