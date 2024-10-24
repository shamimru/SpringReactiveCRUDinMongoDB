package com.spring.mongoReactiveCRUD.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongoReactiveCRUD.dto.StudentDTO;
import com.spring.mongoReactiveCRUD.entity.Student;
import com.spring.mongoReactiveCRUD.mapper.StudentMapper;
import com.spring.mongoReactiveCRUD.repository.StudentRepository;
import com.spring.mongoReactiveCRUD.service.StudsentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class StudentServiceImpl implements StudsentService{

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public Mono<StudentDTO> saveStudent(StudentDTO S) {
		Student s= StudentMapper.mapToStudent(S);
		Mono<Student> saveStudent=studentRepo.save(s);
		
		return saveStudent.map(student->StudentMapper.mapToStudentDto(s));
	}

	@SuppressWarnings("static-access")
	@Override
	public Mono<StudentDTO> getStudent(String empId) {
		
		Mono<Student>  student= studentRepo.findById(empId);
		return student.map(s->StudentMapper.mapToStudentDto(s));
	}

	@Override
	public Flux<StudentDTO> getAllStudent() {

		Flux<Student> allStudent=studentRepo.findAll();
		return allStudent.map(stu->StudentMapper.mapToStudentDto(stu))
				.switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<StudentDTO> updateStudent(StudentDTO studentDto, String stdId) {
		
		Mono<Student> existingStudent= studentRepo.findById(stdId);
		
		return existingStudent.flatMap(s->{
			s.setFirstName(studentDto.getFirstName());
			s.setLastName(studentDto.getLastName());
			s.setEmail(studentDto.getEmail());
			return studentRepo.save(s);
		}).map(student->StudentMapper.mapToStudentDto(student));
	}

	@Override
	public Mono<?> delete(String id) {
		
		
		return studentRepo.deleteById(id);
	}
	
	
	

}
