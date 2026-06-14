package com.crud.basic.models;

import org.hibernate.annotations.SQLRestriction;

import com.crud.basic.models.enums.GenericStates;
import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@SQLRestriction("state != 'DELETED'")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Table(name = "users")
public abstract class User extends DataAuditory{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(unique = true, nullable = false)
  private String ic;

  @EqualsAndHashCode.Include
  @Column(unique = true, nullable = false)
  private String email;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String lastname;
  
  @Column(nullable = false)
  private Integer age;

  @Enumerated(value = EnumType.STRING)
  @Builder.Default
  private GenericStates state = GenericStates.ACTIVE;

  public void updateStudent(String name, String lastname, Integer age){
    this.name = name;
    this.lastname = lastname;
    this.age = age;
  }

  public void changeStatus(GenericStates status){
    this.state = status;
  }
}
