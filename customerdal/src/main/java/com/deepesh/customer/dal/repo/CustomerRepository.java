package com.deepesh.customer.dal.repo;

import org.springframework.data.repository.CrudRepository;

import com.deepesh.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
