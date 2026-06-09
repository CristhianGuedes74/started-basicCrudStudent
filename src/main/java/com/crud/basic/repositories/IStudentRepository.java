package com.crud.basic.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.basic.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{
  Optional<Student> findByIc(String ic);
}
