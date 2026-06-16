package com.crud.basic.models;

import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter @Setter
public class SystemParameter extends DataAuditory{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false, unique = true)
  private String parameterKey;  // Ej: "OPERATION_DEADLINE_TIME"
  
  @Column(nullable = false)
  private String parameterValue;  // Ej: "10:00:00"
  
  private String description;  // Ej: "Hora límite para operaciones del día"
  
  @Builder.Default
  private boolean active = true;
}
