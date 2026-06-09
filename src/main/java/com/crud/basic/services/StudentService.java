package com.crud.basic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.basic.models.Student;
import com.crud.basic.repositories.IStudentRepository;

@Service
public class StudentService implements IStudentService{
  @Autowired
  private IStudentRepository repository;

  @Override
  public List<Student> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Student> getById(Long id) {
    return repository.findById(id);
  }

  @Override
  public void save(Student student) {
    if(repository.findByIc(student.getIc()).isPresent()) throw new
      RuntimeException("This Student already exist.");

    repository.save(student);
  }

  @Override
  public void modify(Long id, Student student) {
    repository.findById(id).orElseThrow(() ->
      new RuntimeException("Student doesn't found."));

    // oldStudent.setName(student.getName());
    // oldStudent.setLastname(student.getLastname());
    // oldStudent.setAge(student.getAge());
    repository.save(student);
  }

  @Override
  public void remove(Long id) {
    Student studentToDelete = repository.findById(id).orElseThrow(() ->
      new RuntimeException("Student doesn't found."));

    repository.delete(studentToDelete);
  }
}
