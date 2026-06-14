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

import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentModifyRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.services.IStudentService;

import jakarta.validation.Valid;

@RestController
// @RequiredArgsConstructor
@RequestMapping(path = "/api/v1/students")
public class StudentController {
  private final IStudentService studentService;

  public StudentController(IStudentService service){
    this.studentService = service;
  }

  @GetMapping
  public ResponseEntity<List<StudentResponseDTO>> showAllStudent(){
    return ResponseEntity.ok(studentService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentResponseDetailDTO> showStudent(@PathVariable Long id){
    return ResponseEntity.ok(studentService.getById(id));
  }

  @PostMapping
  public ResponseEntity<StudentResponseDetailDTO> registerStudent(@Valid @RequestBody StudentRegisterRequestDTO student){
    StudentResponseDetailDTO response = studentService.save(student);
    return ResponseEntity.status(201).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentResponseDetailDTO> updateStudent(@PathVariable Long id,
      @Valid @RequestBody StudentModifyRequestDTO student){
    StudentResponseDetailDTO response = studentService.modify(id, student);
    return ResponseEntity.ok(response);
  } 

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
    studentService.newRemove(id);
    return ResponseEntity.noContent().build();
  }
}
