package com.crud.basic.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.basic.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{
  Optional<Student> findByIc(String ic);
  Optional<Student> findByEmail(String ic);

  @Modifying
  @Transactional
  @Query("UPDATE User s SET s.state = 'DELETED' WHERE s.id = :id AND s.state != 'DELETED'")
  void softDeletedById(@Param("id") Long id);

  @Query(value = 
    "SELECT u.*, s.* FROM users u LEFT JOIN student s ON u.id = s.id WHERE u.id = :id", 
    nativeQuery = true)
  Optional<Student> findByIdIgnoringFilter(@Param("id") Long id);
}
