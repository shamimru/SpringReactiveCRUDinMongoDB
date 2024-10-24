package com.spring.mongoReactiveCRUD.mapper;

import com.spring.mongoReactiveCRUD.dto.StudentDTO;
import com.spring.mongoReactiveCRUD.entity.Student;

public class StudentMapper {
	public static StudentDTO mapToStudentDto(Student student) {
		
		
		return new StudentDTO(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getEmail()
				);
	}
	
	public static Student mapToStudent(StudentDTO stDTO ) {
		
		return new Student(
				
				stDTO.getId(),
				stDTO.getFirstName(),
				stDTO.getLastName(),
				stDTO.getEmail()
				
				);
				
	}

}
