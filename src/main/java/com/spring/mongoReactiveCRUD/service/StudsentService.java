package com.spring.mongoReactiveCRUD.service;

import org.springframework.stereotype.Service;

import com.spring.mongoReactiveCRUD.dto.StudentDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface StudsentService  {
	
Mono<StudentDTO> saveStudent(StudentDTO S);

Mono<StudentDTO> getStudent (String empId);

Flux<StudentDTO> getAllStudent ();

Mono<StudentDTO> updateStudent(StudentDTO student, String stdId);

Mono<?> delete (String id);

	
	

}
