package com.crud.basic.models.DTOs.subject;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SubjectResponseByAdminDTO(
    @Positive(message = "ID must be positive. Try it again.")
    Long id,

    @NotBlank(message = "Subject name cannot be empty. Try it again.")
    String name,
    
    @NotBlank(message = "Subject code cannot be empty. Try it again.")
    String code,
    
    @Positive(message = "Subject credits must be positive. Try it again.")
    Integer credits,
    
    @Positive(message = "Subject weekly hours must be positive. Try it again.")
    Integer weeklyHours,

    @NotBlank(message = "Subject state cannot be empty. Try it again.")
    String state,
    
    @NotNull(message = "Date cannot be null.")
    Instant createdAt,

    @NotNull(message = "Date cannot be null.")
    Instant updatedAt
) {}
