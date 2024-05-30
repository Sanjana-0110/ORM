package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Course;
import com.spring.model.Student;
import com.spring.model.StudentsSet;
import com.spring.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/detailsform", method = RequestMethod.GET)
	public String details(Model model) {
		System.out.println("details page requested");
		return "details";
	}

	@RequestMapping(value = "/insertStudents", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String createStudentsWithCourses(@RequestBody StudentsSet studentsSet) {
		System.out.println("Insert Students Requested");
		System.out.println("Received students set:");
		System.out.println("Students:");
		for (Student student : studentsSet.getStudents()) {
			System.out.println("Name: " + student.getName());
			System.out.println("Courses:");
			for (Course course : student.getCourses()) {
				System.out.println("Title: " + course.getTitle());
			}
			studentService.saveStudent(student);
		}
		// Set<Course> courses = new HashSet<>();
		// for (Course courseDto : studentDto.getCourses()) {
		// Course course = new Course();
		// course.setTitle(courseDto.getTitle());
		// // Add the student to the course
		// course.getStudents().add(studentDto);
		// courses.add(course);
		// }
		// studentDto.setCourses(courses);

		// Save the student along with their courses

		return "<h1> hello</h1>";

	}

	// @RequestMapping(value = "/getAuthorById", method = RequestMethod.GET)
	// public Optional<Author> getAuthor(Author author, Model model) {
	// Long i = 1l;
	// return authorService.findAuthorById(i);
	// }

	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public String getData(Model model) {
		System.out.println("get controller");
		List<Student> p = studentService.getAllStudents();

		model.addAttribute("allstudents", p);
		return "AllStudents";
	}
}
