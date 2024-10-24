package com.spring.mongoReactiveCRUD.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.spring.mongoReactiveCRUD.entity.Student;

public interface StudentRepository  extends ReactiveCrudRepository<Student, String>{

}
