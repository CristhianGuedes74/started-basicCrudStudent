package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.course.CourseModifyRequestDTO;
import com.crud.basic.models.DTOs.course.CourseRequestDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDetailDTO;

public interface ICourseService {
  List<CourseResponseDTO> getAll();
  CourseResponseDetailDTO getById(Long id);
  CourseResponseDetailDTO save(CourseRequestDTO dto);
  CourseResponseDetailDTO modify(Long id, CourseModifyRequestDTO dto);
  void remove(Long id);
}
