package com.crud.basic.models.DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record StudentResponseDetailByAdminDTO(
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

  LocalDateTime createdAt,
  
  LocalDateTime updatedAt
) {}
