package com.crud.basic.models.DTOs.student;

import java.time.Instant;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record StudentResponseDetailAsAdminDTO(
  @Positive
  Long id,

  @NotBlank(message = "Cédula incorrecta. Inténtelo de nuevo.")
  String ic,
  
  @NotBlank(message = "Nombre incorrecto. Inténtelo de nuevo.")
  String name,

  @NotBlank(message = "Apellido incorrecto. Inténtelo de nuevo.")
  String lastname,

  @Min(6) @Max(52)
  Integer age,

  Instant createdAt,
  
  Instant updatedAt
) {}
