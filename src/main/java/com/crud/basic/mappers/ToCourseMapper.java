package com.crud.basic.mappers;

import java.time.LocalDate;

import com.crud.basic.models.Course;
import com.crud.basic.models.Subject;
import com.crud.basic.models.DTOs.course.CourseModifyRequestDTO;
import com.crud.basic.models.DTOs.course.CourseRequestDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDetailDTO;

public class ToCourseMapper {
  public static CourseResponseDTO toResponseDTO(Course course){
    if(course == null) return null;

    return new CourseResponseDTO(
      course.getId(),
      course.getName(),
      course.getCycle(),
      course.getSubject().getId(),
      course.getSubject().getName()
    );
  }

  public static CourseResponseDetailDTO toResponseDetailDTO(Course course){
    if(course == null) return null;

    return new CourseResponseDetailDTO(
      course.getId(),
      course.getName(),
      course.getCycle(),
      course.getSubject().getId(),
      course.getSubject().getCode(),
      course.getSubject().getName(),
      course.getSubject().getWeeklyHours()
    );
  }

  public static Course toEntity(CourseRequestDTO dto, Subject subject){
    if(dto == null) return null;

    return Course.builder()
      .name(dto.name())
      .cycle(LocalDate.now())
      .subject(subject)
    .build();
  }

  public static void toUpdateEntity(CourseModifyRequestDTO dto, Course course, Subject subject){
    if(dto == null || course == null || subject == null) return;

    course.changeCourseInfo(dto.name(), subject);
    course.changeCourseCycle(dto.cycle());
  }
}
