package com.crud.basic.mappers;

import com.crud.basic.models.Subject;
import com.crud.basic.models.DTOs.subject.SubjectModifyRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectRegisterRequestDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseByAdminDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDTO;
import com.crud.basic.models.DTOs.subject.SubjectResponseDetailDTO;

public class ToSubjectMapper {
  public static SubjectResponseDTO toResponseDTO(Subject subject){
    if(subject == null) return null;
    
    return new SubjectResponseDTO(subject.getId(), subject.getName(), subject.getCode());
  }

  public static SubjectResponseDetailDTO toResponseDetailDTO(Subject subject){
    if(subject == null) return null;
    
    return new SubjectResponseDetailDTO(
      subject.getId(), 
      subject.getName(), 
      subject.getCode(),
      subject.getCredits(),
      subject.getWeeklyHours()
    );
  }

  public static SubjectResponseByAdminDTO toResponseAdminDetailDTO(Subject subject){
    if(subject == null) return null;
    
    return new SubjectResponseByAdminDTO(
      subject.getId(), 
      subject.getName(), 
      subject.getCode(),
      subject.getCredits(),
      subject.getWeeklyHours(),
      subject.getState().name(),
      subject.getCreatedAt(),
      subject.getUpdatedAt()
    );
  }

  public static Subject toEntity(SubjectRegisterRequestDTO dto){
    if(dto == null) return null;

    return Subject.builder()
      .name(dto.name())
      .code(dto.code())
      .credits(dto.credits())
      .weeklyHours(dto.weeklyHours())
    .build();
  }

  public static void toUpdateEntity(SubjectModifyRequestDTO dto, Subject subject){
    if(dto == null || subject == null) return;

    String name = (dto.name() == null) ? subject.getName() : dto.name();
    Integer credits = (dto.credits() == null) ? subject.getCredits() : dto.credits();
    Integer weeklyHours = (dto.weeklyHours() == null) ? subject.getWeeklyHours() : dto.weeklyHours();
    subject.editSubject(name, credits, weeklyHours);
  }
}
