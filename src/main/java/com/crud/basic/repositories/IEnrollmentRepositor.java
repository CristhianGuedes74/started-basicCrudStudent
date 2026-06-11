package com.crud.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.basic.models.Enrollment;

@Repository
public interface IEnrollmentRepositor extends JpaRepository<Enrollment, Long> {
    
}
