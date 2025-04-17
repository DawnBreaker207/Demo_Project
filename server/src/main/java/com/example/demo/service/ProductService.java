package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
	return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findOne(long id) {
	return productRepository.findProductById(id);
    }

    @Transactional
    public Product saveProduct(Product product) {
	return productRepository.save(product);
    }

    @Transactional
    public int updateProduct(Long id, Product product) {
	return productRepository.updateProduct(id, product);
    }

    @Transactional
    public void deleteProduct(long id) {
	productRepository.deleteById(id);
    }

}
