package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.enrollment.EnrollmentRequestDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDTO;
import com.crud.basic.models.DTOs.enrollment.EnrollmentResponseDetailDTO;

public interface IEnrollmentService {
  List<EnrollmentResponseDTO> getAll();
  EnrollmentResponseDetailDTO getById(Long id);
  EnrollmentResponseDetailDTO save(EnrollmentRequestDTO dto);
  EnrollmentResponseDetailDTO modify(Long id, EnrollmentRequestDTO dto);
}
