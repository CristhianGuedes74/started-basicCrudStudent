package com.crud.basic.mappers.student;

import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailAsAdminDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;

public class ToStudentMapper {
    public static StudentResponseDTO toResponse(Student student){
        if(student == null) return null;

        return new StudentResponseDTO(
            student.getStudentId(),
            student.getIc(),
            student.getName()
        );
    }

    public static StudentResponseDetailDTO toResponseDetail(Student student){
        if(student == null) return null;

        return new StudentResponseDetailDTO(
            student.getStudentId(),
            student.getIc(),
            student.getName(),
            student.getLastname(),
            student.getAge()
        );
    }

    public static StudentResponseDetailAsAdminDTO toResponseDetailByAdmin(Student student){
        if(student == null) return null;

        return new StudentResponseDetailAsAdminDTO(
            student.getStudentId(),
            student.getIc(),
            student.getName(),
            student.getLastname(),
            student.getAge(),
            student.getCreatedAt(),
            student.getUpdatedAt()
        );
    }

    public static Student toEntity(StudentRequestDTO dto){
        if(dto == null) return null;

        return Student.builder()
            // .ic(dto.ic())
            .name(dto.name())
            .lastname(dto.lastname())
            .age(dto.age())
        .build();
    }

    public static Student toEntityRegister(StudentRegisterRequestDTO dto){
        if(dto == null) return null;

        return Student.builder()
            .ic(dto.ic())
            .name(dto.name())
            .lastname(dto.lastname())
            .age(dto.age())
        .build();
    }
}
