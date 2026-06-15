package com.crud.basic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.basic.exceptions.course.CourseNotFoundException;
import com.crud.basic.exceptions.subject.SubjectNotFoundException;
import com.crud.basic.mappers.ToCourseMapper;
import com.crud.basic.models.Course;
import com.crud.basic.models.Subject;
import com.crud.basic.models.DTOs.course.CourseModifyRequestDTO;
import com.crud.basic.models.DTOs.course.CourseRequestDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDetailDTO;
import com.crud.basic.repositories.ICourseRepository;
import com.crud.basic.repositories.ISubjectRepository;

@Service
public class CourseService implements ICourseService{
  private final ICourseRepository courseRepository;
  private final ISubjectRepository subjectRepository;

  public CourseService(ICourseRepository courseRepository, ISubjectRepository subjectRepository){
    this.courseRepository = courseRepository;
    this.subjectRepository = subjectRepository;
  }

  @Override
  public List<CourseResponseDTO> getAll() {
    return courseRepository.findAll().stream()
      .map(ToCourseMapper::toResponseDTO)
    .toList();
  }

  @Override
  public CourseResponseDetailDTO getById(Long id) {
    Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

    return ToCourseMapper.toResponseDetailDTO(course);
  }

  @Override
  public CourseResponseDetailDTO save(CourseRequestDTO dto) {
    Subject subject = subjectRepository.findByCode(dto.subjectCode()).orElseThrow(
      () -> new CourseNotFoundException());

    Course course = ToCourseMapper.toEntity(dto, subject);
    return ToCourseMapper.toResponseDetailDTO(courseRepository.save(course));
  }

  @Override
  public CourseResponseDetailDTO modify(Long id, CourseModifyRequestDTO dto) {
    Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());
    
    Subject subject = subjectRepository.findByCode(dto.subjectCode()).orElseThrow(
      () -> new SubjectNotFoundException());

    ToCourseMapper.toUpdateEntity(dto, course, subject);
    return ToCourseMapper.toResponseDetailDTO(courseRepository.save(course));
  }

  @Override
  public void remove(Long id) {
    if(courseRepository.findById(id).isEmpty()) throw new CourseNotFoundException();

    courseRepository.softDeleteById(id);
  }
}
