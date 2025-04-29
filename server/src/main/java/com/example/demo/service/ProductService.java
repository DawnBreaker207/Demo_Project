package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.product.ProductRequestDTO;
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

    public Product create(ProductRequestDTO productDto) throws SQLException {
	Product product = new Product();
	product.setId(productDto.getId());
	product.setName(productDto.getName());
	product.setPrice(productDto.getPrice());
	return productRepository.create(product);
    }

    public Product update(Long id, ProductRequestDTO productDto) throws SQLException {
	Product checkExist = productRepository.getOne(id);
	
	if (checkExist == null) {
	    throw new SQLException("Product not found");
	}
	
	checkExist.setName(productDto.getName());
	checkExist.setPrice(productDto.getPrice());
	return productRepository.update(checkExist);
    }

    public void delete(long id) throws SQLException {
	productRepository.delete(id);
    }

}
