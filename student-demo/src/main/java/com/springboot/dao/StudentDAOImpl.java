package com.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Student getStudentById(int theId) {
		
		Student theStudent = entityManager.find(Student.class, theId);
		
		return theStudent;
	}

}
