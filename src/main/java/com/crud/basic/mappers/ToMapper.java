package com.crud.basic.mappers;

import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.StudentRequestDTO;
import com.crud.basic.models.DTOs.StudentResponseDTO;
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

    public static Student toEntity(StudentRequestDTO dto){
        if(dto == null) return null;

        return Student.builder()
            .ic(dto.ic())
            .name(dto.name())
            .lastname(dto.lastname())
            .age(dto.age())
        .build();
    }
}
