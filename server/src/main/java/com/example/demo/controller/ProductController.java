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

import com.example.demo.dto.product.ProductRequestDTO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
	this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable long id) throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(productService.getOne(id));
    }

    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody ProductRequestDTO product) throws SQLException {
	return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @RequestBody ProductRequestDTO product)
	    throws SQLException {
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws SQLException {
	productService.delete(id);
    }
}
