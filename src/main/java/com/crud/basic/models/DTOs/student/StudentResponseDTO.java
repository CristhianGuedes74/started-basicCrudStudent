package com.crud.basic.models.DTOs.student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record StudentResponseDTO(
  @Positive(message = "ID must be positive. Try it again.")
  Long id,

  @NotEmpty(message = "Student IC incorrect. Try it again.")
  String ic,
  
  @NotEmpty(message = "Student name incorrect. Try it again.")
  String name
) {}
