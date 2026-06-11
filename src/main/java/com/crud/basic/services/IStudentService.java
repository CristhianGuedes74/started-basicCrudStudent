package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.student.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.student.StudentRequestDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailAsAdminDTO;
import com.crud.basic.models.DTOs.student.StudentResponseDetailDTO;

public interface IStudentService {
  List<StudentResponseDTO> getAll();
  List<StudentResponseDetailDTO> getAllDetails();
  List<StudentResponseDetailAsAdminDTO> getAllDetailsByAdmin();
  StudentResponseDetailAsAdminDTO getByIdByAdmin(Long id);
  StudentResponseDetailDTO getById(Long id);
  StudentResponseDetailDTO save(StudentRegisterRequestDTO student);
  StudentResponseDetailDTO modify(Long id, StudentRequestDTO dto);
  void remove(Long id);
}
