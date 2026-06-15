package com.crud.basic.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.basic.models.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long>{
  Optional<Course> findByName(String name);

  @Modifying
  @Transactional
  @Query("UPDATE Course c SET c.state = 'DELETED' WHERE c.id = :id AND c.state != 'DELETED'")
  void softDeleteById(@Param("id") Long id);
}
