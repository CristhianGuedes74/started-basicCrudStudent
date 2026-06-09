package com.crud.basic.services;

import java.util.List;
import java.util.Optional;

import com.crud.basic.models.Student;
import com.crud.basic.models.DTOs.StudentResponseDetailDTO;

public interface IStudentService {
  List<Student> getAll();
  List<StudentResponseDetailDTO> getAllDetails();
  Optional<Student> getById(Long id);
  void save(Student student);
  void modify(Long id, Student student);
  void remove(Long id);
}
