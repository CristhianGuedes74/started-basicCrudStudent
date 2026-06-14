package com.crud.basic.models.DTOs.subject;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectResponseAsAdminDTO(
    @Positive(message = "ID must be positive. Try it again.")
    Long subjectId,

    @NotBlank(message = "Nombre de Materia incorrecta. Inténtelo de nuevo.")
    String name,
    
    @NotBlank(message = "Código de Materia incorrecta. Inténtelo de nuevo.")
    String code,
    
    @Positive(message = "Número de Créditos incorrecta. Inténtelo de nuevo.")
    Integer credits,
    
    @Positive(message = "Número de Horas Semanales incorrecta. Inténtelo de nuevo.")
    Integer weeklyHours,

    @Positive(message = "ID must be positive. Try it again.")
    Long courseId,

    @NotBlank(message = "Código de Materia incorrecta. Inténtelo de nuevo.")
    String courseName,

    Instant createdAt,
    
    Instant updatedAt
) {}
