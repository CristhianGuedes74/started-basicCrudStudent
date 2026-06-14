package com.crud.basic.mappers.student;

import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.student.StudentModifyRequestDTO;
import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.models.DTOs.student.StudentByAdminResponseDTO;

public class ToStudentMapper {
  public static StudentResponseDTO toResponseDTO(Student student){
    if(student == null) return null;

    return new StudentResponseDTO(
      student.getId(),
      student.getIc(),
      student.getName()
    );
  }

  public static StudentResponseDetailDTO toResponseDetailDTO(Student student){
    if(student == null) return null;

    return new StudentResponseDetailDTO(
      student.getId(),
      student.getIc(),
      student.getEmail(),
      student.getName(),
      student.getLastname(),
      student.getAge()
    );
  }

  public static StudentByAdminResponseDTO toResponseAdminDetailDTO(Student student){
    if(student == null) return null;

    return new StudentByAdminResponseDTO(
      student.getId(),
      student.getIc(),
      student.getEmail(),
      student.getName(),
      student.getLastname(),
      student.getAge(),
      student.getState().name(),
      student.getAcademicState().name(),
      student.getCreatedAt(),
      student.getUpdatedAt()
    );
  }

  public static Student toEntity(StudentModifyRequestDTO dto){
    if(dto == null) return null;

    return Student.builder()
      .name(dto.name())
      .lastname(dto.lastname())
      .age(dto.age())
    .build();
  }

  public static Student toEntity(StudentRegisterRequestDTO dto){
    if(dto == null) return null;

    return Student.builder()
      .ic(dto.ic())
      .email(dto.email())
      .name(dto.name())
      .lastname(dto.lastname())
      .age(dto.age())
    .build();
  }
}
