package com.crud.basic.models.DTOs.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StudentRegisterRequestDTO(
  @NotEmpty(message = "Student IC incorrect. Try it again.")
  String ic,

  @Email(message = "Student email incorrect. Try it again.")
  @NotEmpty(message = "Student email cannot be empty. Try it again.")
  String email,
  
  @NotEmpty(message = "Student name incorrect. Try it again.")
  String name,

  @NotEmpty(message = "Student Lastname incorrect. Try it again.")
  String lastname,

  @NotNull(message = "Student age cannot be null.")
  @Min(value = 6, message = "The minimum Student age value is 6.")
  @Max(value = 52, message = "The maximum student age value is 52.")
  Integer age
) {}
