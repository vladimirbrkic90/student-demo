package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.StudentDAO;
import com.springboot.dao.StudentDAOImpl;
import com.springboot.entity.Student;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	private StudentDAO studentDAO;
	
	@Autowired
	public StudentService(StudentRepository studentRepository, StudentDAO studentDAO) {
		this.studentRepository = studentRepository;
		this.studentDAO = studentDAO;
	}
	
	@Transactional
	public Student getStudentById(int theId) {
		
		Student theStudent = studentDAO.getStudentById(theId);
		
		return theStudent;
		
	}
	
	@Transactional
	public Optional<Student> getStudent(int id) {
		
		Optional<Student> student = studentRepository.findById(id);
		
		return student;
	}
	
	@Transactional
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<>();
		//studentRepository.findAll().forEach((Student s) -> students.add(s));
		
		students.addAll(studentRepository.findAll());
		
		/*for(Student s : studentRepository.findAll()) {
			students.add(s);
		}*/
		
		return students;
	}
	
	@Transactional
	public void saveStudent(Student theStudent) {
		
		studentRepository.save(theStudent);
		
	}
	
	@Transactional
	public void deleteStudent(Integer theId) {
		
		studentRepository.deleteById(theId);
		
	}

}














