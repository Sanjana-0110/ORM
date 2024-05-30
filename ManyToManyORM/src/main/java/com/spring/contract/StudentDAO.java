package com.spring.contract;

import java.util.List;

import com.spring.model.Student;

public interface StudentDAO {

	public void saveStudent(Student s);

	public List<Student> getAllStudents();
}
