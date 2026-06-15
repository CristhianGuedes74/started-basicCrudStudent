package com.crud.basic.models.DTOs.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRegisterRequestDTO(
  @NotBlank(message = "Student IC incorrect. Try it again.")
  String ic,

  @Email(message = "Student email incorrect. Try it again.") @NotBlank(message = 
    "Student email cannot be empty. Try it again.")
  String email,
  
  @NotBlank(message = "Student name incorrect. Try it again.")
  String name,

  @NotBlank(message = "Student Lastname incorrect. Try it again.")
  String lastname,

  @NotNull(message = "Student age cannot be null.")
  @Min(6) @Max(52)
  Integer age
) {}
