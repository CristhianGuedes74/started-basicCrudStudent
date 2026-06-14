package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentModifyRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;
import com.crud.basic.models.DTOs.student.StudentByAdminResponseDTO;

public interface IStudentService {
  List<StudentResponseDTO> getAll();
  List<StudentResponseDetailDTO> getAllDetails();
  StudentResponseDetailDTO getById(Long id);
  StudentByAdminResponseDTO getByIdIgnoringFilter(Long id);
  StudentResponseDetailDTO save(StudentRegisterRequestDTO student);
  StudentResponseDetailDTO modify(Long id, StudentModifyRequestDTO dto);
  void remove(Long id);
}
