package com.crud.basic.config;

import org.springframework.boot.CommandLineRunner;

import com.crud.basic.models.SystemParameter;
import com.crud.basic.repositories.ISystemParameterRepository;

public class DataInizializator implements CommandLineRunner{
  private final ISystemParameterRepository repository;

  public DataInizializator(ISystemParameterRepository repository){
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    // Crear parámetro por defecto si no existe
    if (repository.findByParameterKey("OPERATION_DEADLINE_TIME").isEmpty()) {
      SystemParameter defaultParam = SystemParameter.builder()
        .parameterKey("OPERATION_DEADLINE_TIME")
        .parameterValue("21:45:00")
        .description("Hora límite para operaciones del sistema (formato HH:MM:SS)")
        .active(true)
      .build();
      repository.save(defaultParam);
    }
  }
}
