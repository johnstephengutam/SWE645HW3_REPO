package com.hw3.survey_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hw3.survey_application.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
