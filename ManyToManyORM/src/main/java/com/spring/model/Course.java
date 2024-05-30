package com.spring.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanjana187course")
public class Course {

	@Id
	private Long id;

	private String title;

	@ManyToMany(mappedBy = "courses", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> students = new HashSet<>();

	// Constructors, getters, and setters

	// Default constructor

	public Course() {

	}

	// Constructor with title

	public Course(String title) {

		this.title = title;

	}

	// Getters and setters

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public Set<Student> getStudents() {

		return students;

	}

	public void setStudents(Set<Student> students) {

		this.students = students;

	}

}