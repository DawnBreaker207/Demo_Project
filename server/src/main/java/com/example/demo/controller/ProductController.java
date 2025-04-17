package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
	return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable long id) {
	return ResponseEntity.status(HttpStatus.OK).body(productService.findOne(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
	return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Integer> update(@PathVariable long id, @RequestBody Product product) {
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(id, product));
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
	productService.deleteProduct(id);
    }
}
