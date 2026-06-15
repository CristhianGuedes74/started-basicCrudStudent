package com.crud.basic.models.DTOs.subject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record SubjectResponseDetailDTO(
    @Positive(message = "ID must be positive. Try it again.")
    Long id,

    @NotEmpty(message = "Subject name cannot be empty. Try it again.")
    String name,
    
    @NotEmpty(message = "Subject code cannot be empty. Try it again.")
    String code,

    @Positive(message = "Subject credits must be positive. Try it again.")
    @Min(value = 1, message = "The minimum Subject credits value is 1.")
    Integer credits,
    
    @Positive(message = "Subject weekly hours must be positive. Try it again.")
    @Min(value = 3, message = "The minimum weekly hours value is 3.")
    Integer weeklyHours
) {}
