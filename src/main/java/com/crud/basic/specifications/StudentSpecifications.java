package com.crud.basic.specifications;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.crud.basic.models.Course;
import com.crud.basic.models.Enrollment;
import com.crud.basic.models.Student;
import com.crud.basic.models.enums.GenericStates;
import com.crud.basic.models.enums.StudentStates;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class StudentSpecifications {
  // Filtro por nombre (búsqueda parcial, case insensitive)
  public static Specification<Student> hasName(String name) {
    return (root, query, cb) -> {
      if (name == null || name.isBlank()) {
        return cb.conjunction(); // Sin filtro
      }
      return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    };
  }
  
  // Filtro por email
  public static Specification<Student> hasEmail(String email) {
    return (root, query, cb) -> {
      if (email == null || email.isBlank()) {
        return cb.conjunction();
      }
      return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    };
  }
  
  // Filtro por estado del estudiante (ACTIVE, INACTIVE, DELETED)
  public static Specification<Student> hasState(String state) {
    return (root, query, cb) -> {
      if (state == null || state.isBlank()) {
        return cb.conjunction();
      }
      try {
        GenericStates genericState = GenericStates.valueOf(state.toUpperCase());
        return cb.equal(root.get("state"), genericState);
      } catch (IllegalArgumentException e) {
        return cb.disjunction(); // No resultados si estado inválido
      }
    };
  }
  
  // 🔥 FILTRO POR RELACIÓN: Estudiantes en un curso específico (por nombre del curso)
  // Esto usa la relación Student -> Enrollment -> Course
  public static Specification<Student> hasCourseName(String courseName) {
    return (root, query, cb) -> {
      if (courseName == null || courseName.isBlank()) {
        return cb.conjunction();
      }
    
      // Student tiene una lista de enrollments
      Join<Student, Enrollment> enrollmentJoin = root.join("enrollments", JoinType.LEFT);
      // Enrollment tiene un course
      Join<Enrollment, Course> courseJoin = enrollmentJoin.join("course", JoinType.LEFT);
    
      // Para evitar duplicados en los resultados
      query.distinct(true);
      
      return cb.like(cb.lower(courseJoin.get("name")), "%" + courseName.toLowerCase() + "%");
    };
  }
  
  // Filtro por rango de fechas de registro (si tienes createdAt en DataAuditory)
  public static Specification<Student> registeredBetween(LocalDate startDate, LocalDate endDate) {
    return (root, query, cb) -> {
      if (startDate == null && endDate == null) {
        return cb.conjunction();
      }
    
      // Asumiendo que DataAuditory tiene createdAt como LocalDateTime
      if (startDate != null && endDate != null) {
        return cb.between(root.get("createdAt"), startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
      } else if (startDate != null) {
        return cb.greaterThanOrEqualTo(root.get("createdAt"), startDate.atStartOfDay());
      } else {
        return cb.lessThanOrEqualTo(root.get("createdAt"), endDate.atTime(23, 59, 59));
      }
    };
  }
  
  // Filtro por estado académico (ENROLLED, ON_LEAVE, GRADUATED)
  public static Specification<Student> hasAcademicStatus(String academicStatus) {
    return (root, query, cb) -> {
      if (academicStatus == null || academicStatus.isBlank()) {
        return cb.conjunction();
      }
      try {
        StudentStates status = StudentStates.valueOf(academicStatus.toUpperCase());
        return cb.equal(root.get("academicStatus"), status);
      } catch (IllegalArgumentException e) {
        return cb.disjunction();
      }
    };
  }
}
