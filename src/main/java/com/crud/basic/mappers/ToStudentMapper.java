package com.crud.basic.mappers;

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

  public static void toUpdateEntity(StudentModifyRequestDTO dto, Student student){
    if(dto == null || student == null) return;

    String name = (dto.name() == null) ? student.getName() : dto.name();
    String lastname = (dto.lastname() == null) ? student.getLastname() : dto.lastname();
    Integer age = (dto.age() == null) ? student.getAge() : dto.age();
    student.updateStudent(name, lastname, age);
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
