package com.crud.basic.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentModifyRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.models.DTOs.student.StudentByAdminResponseDTO;
import com.crud.basic.models.DTOs.student.StudentFilterDTO;
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

  // 🆕 NUEVO ENDPOINT: Filtrar estudiantes con paginación
  @GetMapping("/filter")
  public ResponseEntity<Page<StudentResponseDTO>> filterStudents(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email,
    @RequestParam(required = false) String state,
    @RequestParam(required = false) String academicStatus,
    @RequestParam(required = false) String courseName,  // 🔥 Filtro por curso relacionado
    @RequestParam(required = false) LocalDate registeredFrom,
    @RequestParam(required = false) LocalDate registeredTo,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "id") String sortBy,
    @RequestParam(defaultValue = "asc") String sortDir
  ) {
    // Crear DTO con los parámetros
    StudentFilterDTO filters = new StudentFilterDTO();
    filters.setName(name);
    filters.setEmail(email);
    filters.setState(state);
    filters.setAcademicStatus(academicStatus);
    filters.setCourseName(courseName);
    filters.setRegisteredFrom(registeredFrom);
    filters.setRegisteredTo(registeredTo);
    filters.setPage(page);
    filters.setSize(size);
    filters.setSortBy(sortBy);
    filters.setSortDir(sortDir);
  
    return ResponseEntity.ok(studentService.filterStudents(filters));
  }

  @GetMapping
  public ResponseEntity<List<StudentResponseDTO>> showAllStudent(){
    return ResponseEntity.ok(studentService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentResponseDetailDTO> showStudent(@PathVariable Long id){
    return ResponseEntity.ok(studentService.getById(id));
  }

  @GetMapping("/admin/{id}")
  public ResponseEntity<StudentByAdminResponseDTO> showStudentAllDetails(@PathVariable Long id){
    return ResponseEntity.ok(studentService.getByIdIgnoringFilter(id));
  }

  @PostMapping
  public ResponseEntity<StudentResponseDetailDTO> registerStudent(@Valid @RequestBody StudentRegisterRequestDTO student){
    return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentResponseDetailDTO> updateStudent(@PathVariable Long id,
      @Valid @RequestBody StudentModifyRequestDTO student){
    return ResponseEntity.ok(studentService.modify(id, student));
  } 

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
    studentService.remove(id);
    return ResponseEntity.noContent().build();
  }
}
