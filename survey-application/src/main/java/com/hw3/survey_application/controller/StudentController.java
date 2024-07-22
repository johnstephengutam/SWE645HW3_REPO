package com.hw3.survey_application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hw3.survey_application.model.Student;
import com.hw3.survey_application.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		if (student.getId() != null && studentService.existsById(student.getId())) { 
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Employee deleted successfully.", HttpStatus.OK);
	}
	
}
