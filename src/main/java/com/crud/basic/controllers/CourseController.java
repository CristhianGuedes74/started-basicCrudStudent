package com.crud.basic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.DTOs.course.CourseModifyRequestDTO;
import com.crud.basic.models.DTOs.course.CourseRequestDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDTO;
import com.crud.basic.models.DTOs.course.CourseResponseDetailDTO;
import com.crud.basic.services.ICourseService;
import com.crud.basic.validations.IOnCreated;
import com.crud.basic.validations.IOnUpdated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
  private final ICourseService service;

  public CourseController(ICourseService service){
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<CourseResponseDTO>> showAllCourses(){
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseResponseDetailDTO> showCourse(@PathVariable Long id){
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping
  public ResponseEntity<CourseResponseDetailDTO> registerCourse(@Valid @Validated(value = IOnCreated.class) @RequestBody CourseRequestDTO dto){
    return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CourseResponseDetailDTO> updateCourse(@PathVariable Long id, 
    @Valid @Validated(value = IOnUpdated.class) @RequestBody CourseModifyRequestDTO dto){
    return ResponseEntity.ok(service.modify(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
    service.remove(id);
    return ResponseEntity.noContent().build();
  }
}
