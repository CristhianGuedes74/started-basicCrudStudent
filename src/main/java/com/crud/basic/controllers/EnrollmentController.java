package com.crud.basic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.DTOs.enrollment.EnrollmentRequestDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDetailDTO;
import com.crud.basic.services.IEnrollmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
  private final IEnrollmentService service;

  public EnrollmentController(IEnrollmentService service){
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<EnrollmentResponseDTO>> showAllEnrolled(){
    return ResponseEntity.ok(service.getAll());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<EnrollmentResponseDetailDTO> showEnrolled(@PathVariable Long id){
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping
  public ResponseEntity<EnrollmentResponseDetailDTO> registerEnrolled(@Valid @RequestBody EnrollmentRequestDTO dto){
    return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EnrollmentResponseDetailDTO> updateEnrolled(@PathVariable Long id,
    @Valid @RequestBody EnrollmentRequestDTO dto){
    return ResponseEntity.ok(service.modify(id, dto));
  }
}
