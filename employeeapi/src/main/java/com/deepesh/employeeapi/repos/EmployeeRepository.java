package com.deepesh.employeeapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.employeeapi.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee>findByOrderByGenderAsc();




}
