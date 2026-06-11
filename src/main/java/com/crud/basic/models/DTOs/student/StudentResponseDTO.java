package com.crud.basic.models.DTOs.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record StudentResponseDTO(
  @Positive(message = "El Identificador debe ser positivo. Inténtelo de nuevo.")
  Long id,

  @NotBlank(message = "Cédula incorrecta. Inténtelo de nuevo.")
  String ic,
  
  @NotBlank(message = "Nombre incorrecto. Inténtelo de nuevo.")
  String name
) {}
