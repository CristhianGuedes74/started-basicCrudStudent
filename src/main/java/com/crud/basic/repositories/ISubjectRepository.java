package com.crud.basic.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.basic.models.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>{
  Optional<Subject> findByCode(String code);

  @Modifying
  @Transactional
  @Query("UPDATE Subject s SET s.state = 'DELETED' WHERE s.id = :id AND s.state != 'DELETED'")
  void softDeletedById(@Param("id") Long id);

  @Query(value = "SELECT * FROM subject s WHERE s.id = :id", nativeQuery = true)
  Optional<Subject> findByIdIgnoringFilter(@Param("id") Long id);
}
