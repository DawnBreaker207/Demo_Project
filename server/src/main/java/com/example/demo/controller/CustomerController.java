package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.customer.CustomerRequestDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
	this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll() throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable long id) throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(customerService.getOne(id));
    }

    @PostMapping("")
    public ResponseEntity<Customer> save(@RequestBody CustomerRequestDTO customer) throws SQLException {
	return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable long id, @RequestBody CustomerRequestDTO customer)
	    throws SQLException {
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.update(id, customer));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws SQLException {
	customerService.delete(id);
    }
}