package com.hw3.survey_application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hw3.survey_application.model.Student;
import com.hw3.survey_application.repository.StudentRepository;
import com.hw3.survey_application.service.StudentService;

import com.hw3.survey_application.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	public StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}
	}
	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", id));
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setStreetAddress(student.getStreetAddress());
        existingStudent.setCity(student.getCity());
        existingStudent.setState(student.getState());
        existingStudent.setZip(student.getZip());
        existingStudent.setTelephoneNumber(student.getTelephoneNumber());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDateOfSurvey(student.getDateOfSurvey());
        existingStudent.setLikedMost(student.getLikedMost());
        existingStudent.setInterestSource(student.getInterestSource());
        existingStudent.setRecommendationLikelihood(student.getRecommendationLikelihood());
        
		
		studentRepository.save(existingStudent);
		
		return existingStudent;
	}
	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
		
	}
	
	@Override
    public boolean existsById(Long id) { // Use Long instead of long
        return studentRepository.existsById(id);
    }
	
}
