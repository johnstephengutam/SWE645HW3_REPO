package com.hw3.survey_application.service;

import java.util.List;

import com.hw3.survey_application.model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	Student updateStudent(Student student, long id);
	void deleteStudent(long id);
	boolean existsById(Long id);
}
