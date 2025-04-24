package com.example.demo.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final DataSource dataSource;

    public ProductRepositoryImpl(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() throws SQLException {
	String sql = "SELECT * FROM product";
	List<Product> products = new ArrayList<>();

	try (var conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    try (var resultSet = prepare.executeQuery()) {
		while (resultSet.next()) {
		    var product = new Product();

		    product.setId(resultSet.getLong("id"));
		    product.setName(resultSet.getString("name"));
		    product.setPrice(resultSet.getBigDecimal("price"));

		    products.add(product);
		}
	    }
	    return products;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Product getOne(long id) throws SQLException {
	String sql = "SELECT * FROM product WHERE id = ( ? )";
	Product product = new Product();
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setLong(1, id);
	    try (ResultSet result = prepare.executeQuery()) {
		while (result.next()) {
		    product.setId(result.getInt("id"));
		    product.setName(result.getString("name"));
		    product.setPrice(result.getBigDecimal("price"));
		}
	    }
	    return product;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}

    }

    @Override
    public Product create(Product p) throws SQLException {
	String sql = "INSERT INTO product (name, price) VALUES ( ? , ?)";
	Product product = new Product();
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setString(2, product.getName());
	    prepare.setBigDecimal(3, product.getPrice());
	    try (ResultSet result = prepare.executeQuery()) {
		while (result.next()) {
		    product.setId(result.getInt("id"));
		    product.setName(result.getString("name"));
		    product.setPrice(result.getBigDecimal("price"));
		}
	    }

	    return product;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Product update(Product t) throws SQLException {
	String sql = "UPDATE product SET name = ? price = ? WHERE id = ?";
	String update = "SELECT * FROM product";
	Product product = new Product();
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setString(2, product.getName());
	    prepare.setBigDecimal(3, product.getPrice());
	    prepare.executeUpdate();
	    try (ResultSet result = prepare.executeQuery(update)) {
		while (result.next()) {
		    product.setId(result.getInt("id"));
		    product.setName(result.getString("name"));
		    product.setPrice(result.getBigDecimal("price"));
		}
	    }

	    return product;

	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public void delete(int id) throws SQLException {
	String sql = "DELETE FROM product WHERE id = ?";
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setInt(1, id);
	    try (ResultSet result = prepare.executeQuery()) {
	    }

	    return;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

}
