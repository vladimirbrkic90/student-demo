package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "fancy-login";
	}
	
	@GetMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> theStudents = studentService.getStudents();
		
		model.addAttribute("students", theStudents);
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, 
							   BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "student-form";
		}
		else {
			studentService.saveStudent(theStudent);
			return "redirect:/student/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model model) {
		
		Student theStudent = studentService.getStudentById(theId);
		
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("studentId") int theId) {
		
		studentService.deleteStudent(theId);
		
		return "redirect:/student/list";
	}

}
