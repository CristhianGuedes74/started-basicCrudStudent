package com.crud.basic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.basic.mappers.ToEnrollmentMapper;
import com.crud.basic.models.Course;
import com.crud.basic.models.Enrollment;
import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.enrollment.EnrollmentRequestDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDetailDTO;
import com.crud.basic.models.enums.StudentStates;
import com.crud.basic.repositories.ICourseRepository;
import com.crud.basic.repositories.IEnrollmentRepository;
import com.crud.basic.repositories.IStudentRepository;

@Service
public class EnrollmentService implements IEnrollmentService{
  private final IEnrollmentRepository enrollmentRepository;
  private final IStudentRepository studentRepository;
  private final ICourseRepository courseRepository;

  public EnrollmentService(IEnrollmentRepository enrollmentRepository, IStudentRepository studentRepository,
    ICourseRepository courseRepository){
    this.enrollmentRepository = enrollmentRepository;
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
  }

  @Override
  public List<EnrollmentResponseDTO> getAll() {
    return enrollmentRepository.findAll().stream()
      .map(ToEnrollmentMapper::toResponseDTO)
    .toList();
  }

  @Override
  public EnrollmentResponseDetailDTO getById(Long id) {
    Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow();

    return ToEnrollmentMapper.toResponseDetailDTO(enrollment);
  }

  @Override
  public EnrollmentResponseDetailDTO save(EnrollmentRequestDTO dto) {
    Student student = studentRepository.findByIc(dto.studentIc()).orElseThrow();
    Course course = courseRepository.findByName(dto.courseName()).orElseThrow();

    Enrollment enrollment = ToEnrollmentMapper.toEntity(dto, student, course);

    student.changeStudentStatus(StudentStates.ENROLLED);
    return ToEnrollmentMapper.toResponseDetailDTO(enrollmentRepository.save(enrollment));
  }

  @Override
  public EnrollmentResponseDetailDTO modify(Long id, EnrollmentRequestDTO dto) {
    Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow();
    
    Student student = studentRepository.findByIc(dto.studentIc()).orElseThrow();
    
    Course course = courseRepository.findByName(dto.courseName()).orElseThrow();
    
    enrollment.getStudent().changeStudentStatus(StudentStates.ON_LEAVE);
    student.changeStudentStatus(StudentStates.ENROLLED);

    ToEnrollmentMapper.toUpdateEntity(dto, enrollment, student, course);

    return ToEnrollmentMapper.toResponseDetailDTO(enrollmentRepository.save(enrollment));
  }
}
