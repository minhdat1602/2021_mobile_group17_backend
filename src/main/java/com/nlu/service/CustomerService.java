package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CustomerEntity;
import com.nlu.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> getAll() {
		List<CustomerEntity> customers = customerRepository.findAll();
		return customers;
	}

	public CustomerEntity getById(long id) {
		CustomerEntity customer = customerRepository.findById(id);
		return customer;
	}

	public CustomerEntity insert(CustomerEntity customerEntity) {
		CustomerEntity customer = customerRepository.save(customerEntity);
		return customer;
	}

	public CustomerEntity update(CustomerEntity customerEntity) {
		CustomerEntity customer = customerRepository.save(customerEntity);
		return customer;
	}

	public void delete(long id) {
		customerRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			customerRepository.deleteById(id);
	}
}
