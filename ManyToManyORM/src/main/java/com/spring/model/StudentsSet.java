package com.spring.model;

import java.util.HashSet;
import java.util.Set;

public class StudentsSet {
	private Set<Student> students = new HashSet<>();
	private Set<Course> courses = new HashSet<>();

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
