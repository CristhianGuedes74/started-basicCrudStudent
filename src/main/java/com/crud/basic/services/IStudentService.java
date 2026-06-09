package com.crud.basic.services;

import java.util.List;
import java.util.Optional;

import com.crud.basic.models.Student;

public interface IStudentService {
  List<Student> getAll();
  Optional<Student> getById(Long id);
  void save(Student student);
  void modify(Long id, Student student);
  void remove(Long id);
}
