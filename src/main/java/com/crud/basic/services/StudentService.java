package com.crud.basic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.basic.exceptions.StudentAlreadyExistException;
import com.crud.basic.exceptions.StudentNotFoundException;
import com.crud.basic.mappers.student.ToStudentMapper;
import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailAsAdminDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.repositories.IStudentRepository;

@Service
public class StudentService implements IStudentService{
  @Autowired
  private IStudentRepository repository;

  @Override
  public List<StudentResponseDTO> getAll() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToStudentMapper::toResponse)
    .toList();
  }

  @Override
  public List<StudentResponseDetailDTO> getAllDetails() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToStudentMapper::toResponseDetail)
    .toList();
  }

  @Override
  public List<StudentResponseDetailAsAdminDTO> getAllDetailsByAdmin() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToStudentMapper::toResponseDetailByAdmin)
    .toList();
  }

  @Override
  public StudentResponseDetailAsAdminDTO getByIdByAdmin(Long id) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() -> 
      new StudentNotFoundException("Student doesn't found with " + id + " ID."));

    return ToStudentMapper.toResponseDetailByAdmin(student);
  }

  @Override
  public StudentResponseDetailDTO getById(Long id) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() -> 
      new StudentNotFoundException("Student doesn't found with " + id + " ID."));

    return ToStudentMapper.toResponseDetail(student);
  }

  @Override
  public StudentResponseDetailDTO save(StudentRegisterRequestDTO student) {
    if(repository.findByIcAndDeletedFalse(student.ic()).isPresent()) throw new
      StudentAlreadyExistException("This Student already exist.");

    Student studentSaved = ToStudentMapper.toEntityRegister(student);
    // studentSaved.setCreatedAt(LocalDateTime.now());
    // studentSaved.setUpdatedAt(LocalDateTime.now());

    return ToStudentMapper.toResponseDetail(repository.save(studentSaved));
  }

  @Override
  public StudentResponseDetailDTO modify(Long id, StudentRequestDTO dto) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() ->
      new StudentNotFoundException("Student doesn't found."));

    student.setName(dto.name());
    student.setLastname(dto.lastname());
    student.setAge(dto.age());
    // student.setUpdatedAt(LocalDateTime.now());

    return ToStudentMapper.toResponseDetail(repository.save(student));
  }

  @Override
  public void remove(Long id) {
    Student studentToDelete = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() ->
      new StudentNotFoundException("Student doesn't found."));

      // studentToDelete.setUpdatedAt(LocalDateTime.now());
      studentToDelete.setDeleted(true);

    repository.save(studentToDelete);
  }
}
