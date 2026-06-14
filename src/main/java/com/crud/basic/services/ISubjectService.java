package com.crud.basic.services;

import java.util.List;

import com.crud.basic.models.DTOs.subject.SubjectModifyRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectRegisterRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseByAdminDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDetailDTO;

public interface ISubjectService {
  List<SubjectResponseDTO> getAll();
  SubjectResponseDetailDTO getById(Long id);
  SubjectResponseByAdminDTO getByIdIgnoringFilter(Long id);
  SubjectResponseDetailDTO save(SubjectRegisterRequestDTO dto);
  SubjectResponseDetailDTO modify(Long id, SubjectModifyRequestDTO dto);
  void remove(Long id);
}
