package com.crud.basic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.basic.exceptions.subject.SubjectCodeDuplicatedException;
import com.crud.basic.exceptions.subject.SubjectNotFoundException;
import com.crud.basic.mappers.ToSubjectMapper;
import com.crud.basic.models.Subject;
import com.crud.basic.models.DTOs.subject.SubjectModifyRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectRegisterRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseByAdminDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDetailDTO;
import com.crud.basic.repositories.ISubjectRepository;

@Service
public class SubjectService implements ISubjectService{
  private final ISubjectRepository repository;

  public SubjectService(ISubjectRepository repository){
    this.repository = repository;
  }

  @Override
  public List<SubjectResponseDTO> getAll() {
    return repository.findAll().stream()
      .map(ToSubjectMapper::toResponseDTO)
    .toList();
  }

  @Override
  public SubjectResponseDetailDTO getById(Long id) {
    Subject subject = repository.findById(id).orElseThrow(() -> 
      new SubjectNotFoundException());

    return ToSubjectMapper.toResponseDetailDTO(subject);
  }

  @Override
  public SubjectResponseByAdminDTO getByIdIgnoringFilter(Long id) {
    Subject subject = repository.findByIdIgnoringFilter(id).orElseThrow(() -> new 
      SubjectNotFoundException());

    return ToSubjectMapper.toResponseAdminDetailDTO(subject);
  }

  @Override
  public SubjectResponseDetailDTO save(SubjectRegisterRequestDTO dto) {
    if(repository.findByCode(dto.code()).isPresent()) throw new SubjectCodeDuplicatedException();

    Subject subject = ToSubjectMapper.toEntity(dto);

    return ToSubjectMapper.toResponseDetailDTO(repository.save(subject));
  }

  @Override
  public SubjectResponseDetailDTO modify(Long id, SubjectModifyRequestDTO dto) {
    Subject subject = repository.findById(id).orElseThrow(() -> 
      new SubjectNotFoundException());

    ToSubjectMapper.toUpdateEntity(dto, subject);

    return ToSubjectMapper.toResponseDetailDTO(repository.save(subject));
  }

  @Override
  public void remove(Long id) {
    if(repository.findById(id).isEmpty()) throw new SubjectNotFoundException();

    // subject.changeStatus(GenericStates.DELETED);
    repository.softDeletedById(id);
  }
}
