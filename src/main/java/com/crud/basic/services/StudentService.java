package com.crud.basic.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crud.basic.exceptions.StudentAlreadyExistException;
import com.crud.basic.exceptions.StudentNotFoundException;
import com.crud.basic.mappers.student.ToStudentMapper;
import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentModifyRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.repositories.IStudentRepository;

@Service
// @RequiredArgsConstructor
public class StudentService implements IStudentService{
  private final IStudentRepository repository;

  public StudentService(IStudentRepository repository){
    this. repository = repository;
  }

  @Override
  public List<StudentResponseDTO> getAll() {
    return repository.findAll()
      .stream()
      .map(ToStudentMapper::toResponseDTO)
    .toList();
  }

  @Override
  public List<StudentResponseDetailDTO> getAllDetails() {
    return repository.findAll()
      .stream()
      .map(ToStudentMapper::toResponseDetailDTO)
    .toList();
  }

  /*
  @Override
  public List<StudentResponseDetailAsAdminDTO> getAllDetailsByAdmin() {
    return repository.findAll()
      .stream()
      .map(ToStudentMapper::toResponseDetailByAdmin)
    .toList();
  }
  */

  /*
  @Override
  public StudentResponseDetailAsAdminDTO getByIdByAdmin(Long id) {
    Student student = repository.findById(id).orElseThrow(() -> 
      new StudentNotFoundException("Student doesn't found with " + id + " ID."));

    return ToStudentMapper.toResponseDetailByAdmin(student);
  }
  */

  @Override
  public StudentResponseDetailDTO getById(Long id) {
    Student student = repository.findById(id).orElseThrow(() -> 
      new StudentNotFoundException());

    return ToStudentMapper.toResponseDetailDTO(student);
  }

  @Override
  public StudentResponseDetailDTO save(StudentRegisterRequestDTO student) {
    repository.findByIc(student.ic()).orElseThrow(() -> new StudentAlreadyExistException());
    repository.findByEmail(student.ic()).orElseThrow(() -> 
      new StudentAlreadyExistException("This email is already used.", HttpStatus.CONFLICT));

    Student studentSaved = ToStudentMapper.toEntity(student);

    return ToStudentMapper.toResponseDetailDTO(repository.save(studentSaved));
  }

  @Override
  public StudentResponseDetailDTO modify(Long id, StudentModifyRequestDTO dto) {
    Student student = repository.findById(id).orElseThrow(() ->
      new StudentNotFoundException());

    // mapper.toEntity(dto, student);
    student.updateStudent(dto.name(), dto.lastname(), dto.age());

    return ToStudentMapper.toResponseDetailDTO(repository.save(student));
  }

  /* 
  @Override
  public void remove(Long id) {
    Student studentToDelete = repository.findById(id).orElseThrow(() ->
      new StudentNotFoundException());

      studentToDelete.changeStatus(StudentStates.DELETED);

    repository.save(studentToDelete);
  }
  */

  @Override
  public void newRemove(Long id) {
    repository.findById(id).orElseThrow(() ->
      new StudentNotFoundException());

    repository.softDeletedById(id);
  }
}
