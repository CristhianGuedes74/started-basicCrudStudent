package com.crud.basic.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.basic.exceptions.StudentAlreadyExistException;
import com.crud.basic.exceptions.StudentNotFoundException;
import com.crud.basic.mappers.ToMapper;
import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.StudentRequestDTO;
import com.crud.basic.models.DTOs.StudentResponseDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailByAdminDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailDTO;
import com.crud.basic.repositories.IStudentRepository;

@Service
public class StudentService implements IStudentService{
  @Autowired
  private IStudentRepository repository;

  @Override
  public List<StudentResponseDTO> getAll() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToMapper::toResponse)
    .toList();
  }

  @Override
  public List<StudentResponseDetailDTO> getAllDetails() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToMapper::toResponseDetail)
    .toList();
  }

  @Override
  public List<StudentResponseDetailByAdminDTO> getAllDetailsByAdmin() {
    return repository.findAllByDeletedFalse()
      .stream()
      .map(ToMapper::toResponseDetailByAdmin)
    .toList();
  }

  @Override
  public StudentResponseDetailByAdminDTO getByIdByAdmin(Long id) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() -> 
      new StudentNotFoundException("Student doesn't found with " + id + " ID."));

    return ToMapper.toResponseDetailByAdmin(student);
  }

  @Override
  public StudentResponseDetailDTO getById(Long id) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() -> 
      new StudentNotFoundException("Student doesn't found with " + id + " ID."));

    return ToMapper.toResponseDetail(student);
  }

  @Override
  public StudentResponseDetailDTO save(StudentRegisterRequestDTO student) {
    if(repository.findByIcAndDeletedFalse(student.ic()).isPresent()) throw new
      StudentAlreadyExistException("This Student already exist.");

    Student studentSaved = ToMapper.toEntityRegister(student);
    studentSaved.setCreatedAt(LocalDateTime.now());
    studentSaved.setUpdatedAt(LocalDateTime.now());

    return ToMapper.toResponseDetail(repository.save(studentSaved));
  }

  @Override
  public StudentResponseDetailDTO modify(Long id, StudentRequestDTO dto) {
    Student student = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() ->
      new StudentNotFoundException("Student doesn't found."));

    student.setName(dto.name());
    student.setLastname(dto.lastname());
    student.setAge(dto.age());
    student.setUpdatedAt(LocalDateTime.now());

    return ToMapper.toResponseDetail(repository.save(student));
  }

  @Override
  public void remove(Long id) {
    Student studentToDelete = repository.findByStudentIdAndDeletedFalse(id).orElseThrow(() ->
      new StudentNotFoundException("Student doesn't found."));

      studentToDelete.setUpdatedAt(LocalDateTime.now());
      studentToDelete.setDeleted(true);

    repository.save(studentToDelete);
  }
}
