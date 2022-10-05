package com.rohit.relation.service;

import java.util.List;

import com.rohit.relation.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theid);

	public void save(Customer theCustomer);

	public void deleteById(int theid);

}
