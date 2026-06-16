package com.crud.basic.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.basic.models.SystemParameter;

public interface ISystemParameterRepository extends JpaRepository<SystemParameter, Long>{
  Optional<SystemParameter> findByParameterKey(String parameterKey);
}
