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

import com.example.demo.dto.order.OrderQueryRequestDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final DataSource dataSource;

    public CustomerRepositoryImpl(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
	String sql = "SELECT * FROM customer";
	List<Customer> customers = new ArrayList<>();

	try (var conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);

	    try (var resultSet = prepare.executeQuery()) {
		while (resultSet.next()) {
		    var customer = new Customer();

		    customer.setId(resultSet.getLong("id"));
		    customer.setName(resultSet.getString("name"));
		    customer.setPhone(resultSet.getString("phone"));
		    customer.setAddress(resultSet.getString("address"));

		    customers.add(customer);
		}
	    }
	    return customers;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Customer getOne(long id) throws SQLException {
	String sql = "SELECT * FROM customer WHERE id = ( ? )";

	Customer customer = new Customer();

	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setLong(1, id);

	    try (ResultSet result = prepare.executeQuery()) {
		if (result.next()) {
		    customer.setId(result.getLong("id"));
		    customer.setName(result.getString("name"));
		    customer.setPhone(result.getString("phone"));
		    customer.setAddress(result.getString("address"));
		    return customer;
		} else {
		    throw new SQLException("No customer found with id " + id);
		}
	    }

	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}

    }

    @Override
    public Customer create(Customer c) throws SQLException {
	String sql = "INSERT INTO customer (name, phone, address) VALUES ( ? , ? , ?)";

	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    prepare.setString(1, c.getName());
	    prepare.setString(2, c.getPhone());
	    prepare.setString(3, c.getAddress());
	    prepare.executeUpdate();

	    try (ResultSet result = prepare.getGeneratedKeys()) {
		if (result.next()) {
		    c.setId(result.getInt(1));
		}
	    }
	    return c;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Customer update(Customer c) throws SQLException {
	String sql = "UPDATE customer SET name = ?, phone = ? , address = ? WHERE id = ?";
	String update = "SELECT * FROM customer WHERE id = ?";
	Customer customer = new Customer();

	try (Connection conn = dataSource.getConnection()) {

	    PreparedStatement prepare = conn.prepareStatement(sql);

	    prepare.setString(1, c.getName());
	    prepare.setString(2, c.getPhone());
	    prepare.setString(3, c.getAddress());
	    prepare.setLong(4, c.getId());
	    
	    prepare.executeUpdate();

	    try (PreparedStatement select = conn.prepareStatement(update)) {
		select.setLong(1, c.getId());
		try (ResultSet result = prepare.executeQuery()) {
		    if (result.next()) {
			customer.setId(result.getInt("id"));
			customer.setName(result.getString("name"));
			customer.setPhone(result.getString("phone"));
			customer.setAddress(result.getString("address"));
			return customer;
		    } else {
			throw new SQLException("No customer found with id " + c.getId());
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
	String sql = "DELETE FROM customer WHERE id = ?";
	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);

	    prepare.setLong(1, id);
	    int rows = prepare.executeUpdate();

	    if (rows == 0) {
		throw new SQLException("No customer found with id " + id);
	    }

	    return;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

   

}
