package com.deepesh.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.employee.model.Employee;

public interface EmployeeReposiotry extends JpaRepository<Employee, Integer> {

}
