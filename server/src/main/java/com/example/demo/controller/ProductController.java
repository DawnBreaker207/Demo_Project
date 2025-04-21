package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
	this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable long id) throws SQLException {
	return ResponseEntity.status(HttpStatus.OK).body(productService.getOne(id));
    }
//
//    @PostMapping("/product")
//    public ResponseEntity<Product> save(@RequestBody Product product) {
//	return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
//    }
//
//    @PutMapping("/product/{id}")
//    public ResponseEntity<Integer> update(@PathVariable long id, @RequestBody Product product) {
//	return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(id, product));
//    }
//
//    @DeleteMapping("/product/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable long id) {
//	productService.deleteProduct(id);
//    }
}
