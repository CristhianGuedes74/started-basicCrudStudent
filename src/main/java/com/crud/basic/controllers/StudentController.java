package com.crud.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.Student;
import com.crud.basic.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
  @Autowired
  private IStudentService studentService;

  @GetMapping
  public ResponseEntity<List<Student>> showAllStudent(){
    return ResponseEntity.ok(studentService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> showStudent(@PathVariable Long id){
    return studentService.getById(id).map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> registerStudent(@Valid @RequestBody Student student){
    studentService.save(student);
    return ResponseEntity.status(201).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student){
    studentService.modify(id, student);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
    studentService.remove(id);
    return ResponseEntity.noContent().build();
  }
}
