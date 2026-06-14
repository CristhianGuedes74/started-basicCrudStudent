package com.crud.basic.models.DTOs.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectRegisterRequestDTO(
    @NotBlank(message = "Subject name cannot be empty. Try it again.")
    String name,
    
    @NotBlank(message = "Subject code cannot be empty. Try it again.")
    String code,
    
    @Positive(message = "Subject credits must be positive. Try it again.")
    Integer credits,
    
    @Positive(message = "Subject weekly hours must be positive. Try it again.")
    Integer weeklyHours
) {}
