package com.crud.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.DTOs.StudentResponseDetailByAdminDTO;
import com.crud.basic.services.IStudentService;

@RestController
@RequestMapping(path = "/admin/v1/students")
public class AdminToStudentController {
  @Autowired
  private IStudentService service;

  @GetMapping
  public ResponseEntity<List<StudentResponseDetailByAdminDTO>> showAllStudents(){
    return ResponseEntity.ok(service.getAllDetailsByAdmin());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<StudentResponseDetailByAdminDTO> showStudent(@PathVariable Long id){
    return ResponseEntity.ok(service.getByIdByAdmin(id));
  }
}
