package com.crud.basic.models.DTOs.course;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseResponseDetailDTO(
  @Positive(message = "ID must be positive. Try it again.")
  Long id,

  @NotBlank(message = "Course name cannot be empty. Try it again.")
  String name,

  @NotNull(message = "Course academic cannot be null.")
  LocalDate cycle,

  @Positive(message = "ID must be positive. Try it again.")
  Long subjectId,

  @NotBlank(message = "Subject code cannot be empty. Try it again.")
  String subjectCode,

  @NotBlank(message = "Subject name cannot be empty. Try it again.")
  String subjectName,

  @Positive(message = "Subject weekly hours must be positive. Try it again.")
  Integer weeklyHours
) {}
