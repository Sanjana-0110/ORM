package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.contract.StudentDAO;
import com.spring.model.Student;
import com.spring.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService implements StudentDAO {

	@Autowired
	private StudentRepository studentRepository;

	/*
	 * 
	 * @Transactional
	 * 
	 * public void enrollStudentInCourse(Long studentId, Long courseId) {
	 * 
	 * 
	 * 
	 */

	@Transactional

	public void saveStudent(Student s) {
		studentRepository.save(s);
	}

	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

}
