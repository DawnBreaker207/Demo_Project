package com.example.demo.repository;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> findByProduct();

    @Query(value = "SELECT * FROM product WHERE id = :id ", nativeQuery = true)
    Product findProductById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = """
    	INSERT INTO product (id , name, SKU, weight, height)
    	VALUES (
    		 :#{#product.id},
    		 :#{#product.name},
    		 :#{#product.SKU},
    		 :#{#product.weight},
    		 :#{#product.height})""", nativeQuery = true)
    Product createProduct(@Param("product") Product product);

    @Modifying
    @Transactional
    @Query(value = """
    	UPDATE product p
    	SET p.name = :#{#product.name},
    		p.SKU =:#{#product.SKU},
    		p.weight =:#{#product.weight},
    		p.height =:#{#product.height}
    	WHERE p.id = :#{#product.id}""", nativeQuery = true)
    int updateProduct(@Param("id") long id, @Param("product") Product product);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product WHERE id = :id ", nativeQuery = true)
    void deleteById(@Param("id") long id);
}
