package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.Impl.ProductRepositoryImpl;

@Service
public class ProductService {

    private final ProductRepositoryImpl productRepository;

    public ProductService(ProductRepositoryImpl productRepository) {
	this.productRepository = productRepository;
    }

    public List<Product> getAll() throws SQLException {
	return productRepository.getAll();
    }

    public Product getOne(long id) throws SQLException {
	return productRepository.getOne(id);
    }

}
