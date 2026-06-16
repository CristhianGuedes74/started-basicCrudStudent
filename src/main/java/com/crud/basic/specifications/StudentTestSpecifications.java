package com.crud.basic.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.crud.basic.models.Student;

public class StudentTestSpecifications {
  public static Specification<Student> hasName(String name){
    return (root, query, cb) -> {
      if(name == null || name.isBlank()){
        return cb.conjunction();
      }

      return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    };
  }

  public static Specification<Student> hasLastname(String lastname){
    return (root, query, cb) -> {
      if(lastname == null || lastname.isBlank()){
        return cb.conjunction();
      }

      return cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    };
  }
}
