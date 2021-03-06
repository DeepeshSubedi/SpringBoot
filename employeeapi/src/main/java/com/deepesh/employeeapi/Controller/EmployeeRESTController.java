package com.deepesh.employeeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepesh.employeeapi.entities.Employee;
import com.deepesh.employeeapi.repos.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeRESTController {

	EmployeeRepository repository;
	@Autowired
	public EmployeeRESTController(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
		
	}
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	List<Employee>getAllEmployee(){
		return repository.findByOrderByGenderAsc();
		
	}


}
