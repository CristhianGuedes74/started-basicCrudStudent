package com.crud.basic.models.DTOs.subject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record SubjectResponseDTO(
    @Positive(message = "ID must be positive. Try it again.")
    Long id,

    @NotEmpty(message = "Subject name cannot be empty. Try it again.")
    String name,
    
    @NotEmpty(message = "Subject code cannot be empty. Try it again.")
    String code
) {}
