package com.crud.basic.models.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StudentRequestDTO(
  @NotBlank(message = "Cédula incorrecta. Inténtelo de nuevo.")
  String ic,
  
  @NotBlank(message = "Nombre incorrecto. Inténtelo de nuevo.")
  String name,

  @NotBlank(message = "Apellido incorrecto. Inténtelo de nuevo.")
  String lastname,

  @Min(6) @Max(52)
  Integer age
) {}
