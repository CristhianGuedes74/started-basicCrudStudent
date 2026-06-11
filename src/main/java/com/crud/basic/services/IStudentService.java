package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.StudentRegisterRequestDTO;
import com.crud.basic.models.DTOs.StudentRequestDTO;
import com.crud.basic.models.DTOs.StudentResponseDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailByAdminDTO;
import com.crud.basic.models.DTOs.StudentResponseDetailDTO;

public interface IStudentService {
  List<StudentResponseDTO> getAll();
  List<StudentResponseDetailDTO> getAllDetails();
  List<StudentResponseDetailByAdminDTO> getAllDetailsByAdmin();
  StudentResponseDetailByAdminDTO getByIdByAdmin(Long id);
  StudentResponseDetailDTO getById(Long id);
  StudentResponseDetailDTO save(StudentRegisterRequestDTO student);
  StudentResponseDetailDTO modify(Long id, StudentRequestDTO dto);
  void remove(Long id);
}
