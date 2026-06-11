package com.crud.basic.models.DTOs.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectResponseDTO(
    @Positive(message = "El Identificador debe ser positivo. Inténtelo de nuevo.")
    Long subjectId,

    @NotBlank(message = "Nombre de Materia incorrecta. Inténtelo de nuevo.")
    String name,
    
    @NotBlank(message = "Código de Materia incorrecta. Inténtelo de nuevo.")
    String code
) {}
