package com.spring.mongoReactiveCRUD.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Student_Details")
public class Student {
	
	@Id
	String id;
	String firstName;
	String lastName;
	String email;

}
