package com.springboot.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	
}
