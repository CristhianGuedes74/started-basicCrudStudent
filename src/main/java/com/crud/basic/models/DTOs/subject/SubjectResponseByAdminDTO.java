package com.crud.basic.models.DTOs.subject;

import java.time.Instant;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SubjectResponseByAdminDTO(
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
    Integer weeklyHours,

    @NotEmpty(message = "Subject state cannot be empty. Try it again.")
    String state,
    
    @NotNull(message = "Date cannot be null.")
    Instant createdAt,

    @NotNull(message = "Date cannot be null.")
    Instant updatedAt
) {}
