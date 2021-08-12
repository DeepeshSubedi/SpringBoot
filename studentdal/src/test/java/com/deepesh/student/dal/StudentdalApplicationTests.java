package com.deepesh.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepesh.student.dal.entities.Student;
import com.deepesh.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {
	@Autowired
	private StudentRepository repo;

	@Test
	void testCreateStudent() {
		Student student = new Student();
		student.setName("Prince Rauniyar");
		student.setCourse("calc I");
		student.setFee(108d);
		repo.save(student);
	}
	

	@Test
	void testUpdateStudent() {
		Student student = repo.findById(2).get();
		student.setFee(50d);
		repo.save(student);
		 
	}

}
