package com.deepesh.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.deepesh.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
