package com.deepesh.customer.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepesh.customer.dal.entities.Customer;
import com.deepesh.customer.dal.repo.CustomerRepository;


@SpringBootTest
class CustomerdalApplicationTests {
	@Autowired
	private CustomerRepository repo;

	@Test
	void testCreateCustomer() {
		Customer customer= new Customer();
		
		customer.setName("Dipesh Subedi");
		customer.setEmail("subedidipesh@gmail.com");
		repo.save(customer);
	}
	@Test
	void testFindCustomerById() {
		Customer customer=repo.findById(1).get();
		System.out.println(customer);
	}
	@Test
	void testUpdateCustomer() {
		Customer customer = repo.findById(2).get();
		customer.setName("Ashmita");
		repo.save(customer);
		 
	}
//	@Test
//	void testDeleteStudent() {
//		Student student = repo.findById(4).get();
//		repo.delete(student);
//	}

}
