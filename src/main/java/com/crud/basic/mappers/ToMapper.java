package com.crud.basic.mappers;

import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.StudentRequestDTO;
import com.crud.basic.models.DTOs.StudentResponseDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailByAdminDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailDTO;

public class ToMapper {
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

    public static StudentResponseDetailByAdminDTO toResponseDetailByAdmin(Student student){
        if(student == null) return null;

        return new StudentResponseDetailByAdminDTO(
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
