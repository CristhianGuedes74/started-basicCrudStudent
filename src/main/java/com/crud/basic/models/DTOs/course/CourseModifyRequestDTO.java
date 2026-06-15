package com.crud.basic.models.DTOs.course;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseModifyRequestDTO(
  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String name,

  @NotNull(message = "Course academic cannot be null.")
  LocalDate cycle,

  @NotBlank(message = "Subject code cannot be empty. Try it again.")
  String subjectCode
) {}
