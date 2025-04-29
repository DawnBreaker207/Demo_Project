package com.example.demo.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		if (result.next()) {
		    product.setId(result.getInt("id"));
		    product.setName(result.getString("name"));
		    product.setPrice(result.getBigDecimal("price"));
		    return product;
		} else {
		    throw new SQLException("No production found with id " + id);
		}
	    }

	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}

    }

    @Override
    public Product create(Product p) throws SQLException {
	String sql = "INSERT INTO product (name, price) VALUES ( ? , ?)";

	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    prepare.setString(1, p.getName());
	    prepare.setBigDecimal(2, p.getPrice());
	    prepare.executeUpdate();

	    try (ResultSet result = prepare.getGeneratedKeys()) {
		if (result.next()) {
		    p.setId(result.getInt(1));
		}
	    }
	    return p;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Product update(Product t) throws SQLException {
	String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
	String update = "SELECT * FROM product WHERE id = ?";
	Product product = new Product();

	try (Connection conn = dataSource.getConnection()) {

	    PreparedStatement prepare = conn.prepareStatement(sql);

	    prepare.setString(1, t.getName());
	    prepare.setBigDecimal(2, t.getPrice());
	    prepare.setLong(3, t.getId());
	    prepare.executeUpdate();

	    try (PreparedStatement select = conn.prepareStatement(update)) {
		select.setLong(1, t.getId());
		try (ResultSet result = prepare.executeQuery()) {
		    if (result.next()) {
			product.setId(result.getInt("id"));
			product.setName(result.getString("name"));
			product.setPrice(result.getBigDecimal("price"));
			return product;
		    } else {
			throw new SQLException("No production found with id " + t.getId());
		    }
		}

	    }

	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public void delete(long id) throws SQLException {
	String sql = "DELETE FROM product WHERE id = ?";
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);

	    prepare.setLong(1, id);
	    int rows = prepare.executeUpdate();

	    if (rows == 0) {
		throw new SQLException("No production found with id " + id);
	    }

	    return;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

}
