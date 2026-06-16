package com.crud.basic.models.DTOs.student;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentFilterDTO {
  private String name;
  private String email;
  private String state;          // ACTIVE, INACTIVE, DELETED
  private String academicStatus; // ENROLLED, ON_LEAVE, GRADUATED
  private String courseName;     // 🔥 Para filtrar por curso relacionado
  private LocalDate registeredFrom;
  private LocalDate registeredTo;
  
  // Paginación
  private int page = 0;
  private int size = 10;
  private String sortBy = "id";
  private String sortDir = "asc";
}
