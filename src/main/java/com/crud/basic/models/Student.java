package com.crud.basic.models;

import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Student extends DataAuditory{
  @Column(nullable = false)
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;
  
  @Column(unique = true, nullable = false)
  private String ic;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String lastname;
  
  @Column(nullable = false)
  private Integer age;
  
  // @Column(nullable = false)
  // private LocalDateTime createdAt;
  
  // @Column(nullable = false)
  // private LocalDateTime updatedAt;

  @Builder.Default
  private Boolean deleted = false;
}
