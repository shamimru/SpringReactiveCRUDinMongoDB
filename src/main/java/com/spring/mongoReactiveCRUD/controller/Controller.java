package com.spring.mongoReactiveCRUD.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongoReactiveCRUD.dto.StudentDTO;
import com.spring.mongoReactiveCRUD.service.impl.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController

public class Controller {
	@Autowired
	StudentServiceImpl serviceImpl;
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveStudent")
	public Mono<StudentDTO> saveStudent(@RequestBody StudentDTO s){
		log.info("[{}",s);
		return serviceImpl.saveStudent(s);
	}
	
	@GetMapping("/getStudentById/{id}")
	public Mono<StudentDTO> getStudentByid(@PathVariable String id){
		log.info("[{}",id);
		return serviceImpl.getStudent(id);
	}
	
	@GetMapping("/getStudent")
	public Flux<StudentDTO> getStudent(){
		log.info("[{}",serviceImpl.getAllStudent());
		return serviceImpl.getAllStudent();
	}
	
	@PostMapping("/update/{stdId}")
	public Mono<StudentDTO> updateStudent(@RequestBody StudentDTO s,@PathVariable String stdId){
		log.info("[{}",stdId);
		return serviceImpl.updateStudent(s, stdId);
	}
	
	@PostMapping("/delete/{id}")
	public Mono<?> delete(@PathVariable String id){
		log.info("[{}",serviceImpl.delete(id));
		return serviceImpl.delete(id);
	}
	

}
