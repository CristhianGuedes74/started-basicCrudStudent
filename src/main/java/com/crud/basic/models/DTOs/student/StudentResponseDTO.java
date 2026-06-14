package com.crud.basic.models.DTOs.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record StudentResponseDTO(
  @Positive(message = "ID must be positive. Try it again.")
  Long id,

  @NotBlank(message = "Student IC incorrect. Try it again.")
  String ic,
  
  @NotBlank(message = "Student name incorrect. Try it again.")
  String name
) {}
