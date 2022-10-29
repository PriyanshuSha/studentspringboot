package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.model.student;
import com.student.services.studentService;

@RestController
public class studentController {
	
	@Autowired
	private studentService service;
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody student s1){
		String status=service.addStudent(s1);
		if(status!=null) {
			
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<student>> getAllStudents(){
		 return new ResponseEntity<>(service.getAllStudents(),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody student s1){
		String status=service.updateStudent(s1);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/student/{stuid}")
	public ResponseEntity<String> deleteStudent(@PathVariable int stuid){
		String status=service.deleteStudent(stuid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
