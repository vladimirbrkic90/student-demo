package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
public class StudentRestController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//@RequestMapping(value="/students", method = RequestMethod.GET)
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		
		List<Student> theStudents = studentService.getStudents();
		
		return new ResponseEntity<List<Student>>(theStudents, HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int theId) {
		
		Optional<Student> theStudent = studentService.getStudent(theId);
		if(theStudent.isPresent()) {
			return new ResponseEntity<Student>(theStudent.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST )
	public ResponseEntity<Void> createStudent(@RequestBody Student student) {
		
		studentService.saveStudent(student);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
		
		studentService.deleteStudent(id);
		
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	//@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	@PutMapping("/students/{id}")
	public ResponseEntity <Optional<Student>> updateStudent(@PathVariable("id") int theId, @RequestBody Student student) {
		
		Optional<Student> theStudent = studentService.getStudent(theId);
		
		theStudent.get().setFirstName(student.getFirstName());
		theStudent.get().setLastName(student.getLastName());
		theStudent.get().setEmail(student.getEmail());
		
		studentService.saveStudent(theStudent.get());
		
		return new ResponseEntity <Optional<Student>>(theStudent, HttpStatus.OK);
	}

}

















