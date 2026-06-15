package com.crud.basic.mappers;

import java.time.LocalDate;

import com.crud.basic.models.Course;
import com.crud.basic.models.Enrollment;
import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.enrollment.EnrollmentRequestDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDetailDTO;

public class ToEnrollmentMapper {
  public static EnrollmentResponseDTO toResponseDTO(Enrollment enrollment){
    if(enrollment == null) return null;

    return new EnrollmentResponseDTO(
      enrollment.getId(),
      enrollment.getStudent().getId(),
      enrollment.getStudent().getIc(),
      enrollment.getCourse().getId(),
      enrollment.getCourse().getName(),
      enrollment.getCourse().getSubject().getId(),
      enrollment.getCourse().getSubject().getCode() 
    );
  }

  public static EnrollmentResponseDetailDTO toResponseDetailDTO(Enrollment enrollment){
    if(enrollment == null) return null;

    return new EnrollmentResponseDetailDTO(
      enrollment.getId(),
      enrollment.getStudent().getId(),
      enrollment.getStudent().getIc(),
      enrollment.getStudent().getName(),
      enrollment.getStudent().getAcademicState().name(),
      enrollment.getCourse().getId(),
      enrollment.getCourse().getName(),
      enrollment.getCourse().getCycle(),
      enrollment.getCourse().getSubject().getId(),
      enrollment.getCourse().getSubject().getCode() 
    );
  }

  public static Enrollment toEntity(EnrollmentRequestDTO dto, Student student, Course course){
    if(dto == null || student == null || course == null) return null;

    // student.changeStudentStatus(StudentStates.ENROLLED);

    return Enrollment.builder()
      .registeredAt(LocalDate.now())
      .student(student)
      .course(course)
    .build();
  }

  public static void toUpdateEntity(EnrollmentRequestDTO dto, Enrollment enrollment, Student student, Course course){
    if(dto == null || enrollment == null || student == null || course == null) return;

    enrollment.changeCriticInfo(student, course);
  }
}
