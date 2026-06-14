package com.crud.basic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.models.DTOs.subject.SubjectModifyRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectRegisterRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseByAdminDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDetailDTO;
import com.crud.basic.services.ISubjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/subjects")
public class SubjectController {
  private final ISubjectService subjectService;

  public SubjectController(ISubjectService subjectService){
    this.subjectService = subjectService;
  }

  @GetMapping
  public ResponseEntity<List<SubjectResponseDTO>> showAllSubjects(){
    return ResponseEntity.ok(subjectService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubjectResponseDetailDTO> showSubject(@PathVariable Long id){
    return ResponseEntity.ok(subjectService.getById(id));
  }

  @GetMapping("/admin/{id}")
  public ResponseEntity<SubjectResponseByAdminDTO> showSubjectAllDetails(@PathVariable Long id){
    return ResponseEntity.ok(subjectService.getByIdIgnoringFilter(id));
  }

  @PostMapping
  public ResponseEntity<SubjectResponseDetailDTO> registerSubject(@Valid @RequestBody SubjectRegisterRequestDTO dto){
    return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<SubjectResponseDetailDTO> updateSubject(@PathVariable Long id,
    @Valid @RequestBody SubjectModifyRequestDTO dto){
    return ResponseEntity.ok(subjectService.modify(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
    subjectService.remove(id);
    return ResponseEntity.noContent().build();
  }
}
