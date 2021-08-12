package com.deepesh.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepesh.employee.model.Employee;
import com.deepesh.employee.repos.EmployeeReposiotry;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
	@Autowired
	EmployeeReposiotry empRepos;
	
	@RequestMapping(value= "/save", method=RequestMethod.POST)
	public Employee saveEmployee(Employee employee) {
		return empRepos.save(employee);
		
	}

}
