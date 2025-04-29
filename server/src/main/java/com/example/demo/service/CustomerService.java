package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.customer.CustomerRequestDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.Impl.CustomerRepositoryImpl;

@Service
public class CustomerService {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerService(CustomerRepositoryImpl customerRepository) {
	this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() throws SQLException {
	return customerRepository.getAll();
    }

    public Customer getOne(long id) throws SQLException {
	return customerRepository.getOne(id);
    }

    public Customer create(CustomerRequestDTO customerDto) throws SQLException {
	Customer customer = new Customer();
	customer.setId(customerDto.getId());
	customer.setName(customerDto.getName());
	customer.setName(customerDto.getPhone());
	customer.setName(customerDto.getAddress());
	
	return customerRepository.create(customer);
    }

    public Customer update(Long id, CustomerRequestDTO customerDto) throws SQLException {
	Customer checkExist = customerRepository.getOne(id);
	
	if (checkExist == null) {
	    throw new SQLException("Customer not found");
	}
	
	checkExist.setName(customerDto.getName());
	checkExist.setName(customerDto.getPhone());
	checkExist.setName(customerDto.getAddress());
	return customerRepository.update(checkExist);
    }

    public void delete(long id) throws SQLException {
	customerRepository.delete(id);
    }

}
