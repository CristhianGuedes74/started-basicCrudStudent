package com.crud.basic.services;

import java.time.Instant;
import java.time.LocalTime;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crud.basic.models.SystemParameter;
import com.crud.basic.repositories.ISystemParameterRepository;

@Service
public class SystemParameterService implements ISystemParameterService{
  private final ISystemParameterRepository repository;
  private static final String OPERATION_DEADLINE_KEY = "OPERATION_DEADLINE_TIME";

  public SystemParameterService(ISystemParameterRepository repository){
    this.repository = repository;
  }

  @Cacheable(value = "systemParameters", key = "#key")
  @Override
  public String getParameterValue(String key) {
    return repository.findByParameterKey(key)
      .map(SystemParameter::getParameterValue)
      .orElse(null);
  }

  @Override
  public LocalTime getOperationDeadline() {
    String deadlineStr = getParameterValue(OPERATION_DEADLINE_KEY);
    if (deadlineStr == null) {
      // Valor por defecto si no existe en BD
      return LocalTime.of(21, 50); // 10:00 AM
    }
    return LocalTime.parse(deadlineStr);
  }

  @Override
  public void updateOperationDeadline(LocalTime newDeadLine) {
    SystemParameter param = repository.findByParameterKey(OPERATION_DEADLINE_KEY)
      .orElse(SystemParameter.builder()
        .parameterKey(OPERATION_DEADLINE_KEY)
        .build());
    
    param.setParameterValue(newDeadLine.toString());
    param.setDescription("Hora límite para operaciones del sistema");
    param.setActive(true);
    param.setUpdatedAt(Instant.now());
    
    repository.save(param);
    
    // Limpiar caché
    evictCache(OPERATION_DEADLINE_KEY);
  }

  @CacheEvict(value = "systemParameters", key = "#key")
  @Override
  public void evictCache(String key) {

  }
  
}
