package com.crud.basic.models.DTOs.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectResponseDTO(
    @Positive(message = "ID must be positive. Try it again.")
    Long subjectId,

    @NotBlank(message = "Nombre de Materia incorrecta. Inténtelo de nuevo.")
    String name,
    
    @NotBlank(message = "Código de Materia incorrecta. Inténtelo de nuevo.")
    String code
) {}
