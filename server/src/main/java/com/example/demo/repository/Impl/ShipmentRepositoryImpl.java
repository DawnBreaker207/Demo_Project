package com.example.demo.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.example.demo.config.Status;
import com.example.demo.model.Customer;
import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;

@Repository
public class ShipmentRepositoryImpl implements ShipmentRepository {
    private final DataSource dataSource;

    public ShipmentRepositoryImpl(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    @Override
    public List<Shipment> getAll() throws SQLException {
	String sql = "SELECT * FROM shipment";
	List<Shipment> shipments = new ArrayList<>();

	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);

	    try (var resultSet = prepare.executeQuery()) {
		while (resultSet.next()) {
		    var shipment = new Shipment();

		    shipment.setId(resultSet.getLong("id"));
		    shipment.setStatus(Status.valueOf(resultSet.getString("status")));
		    shipment.setAmount(resultSet.getLong("amount"));
		    Timestamp paidTimeStamp = (resultSet.getTimestamp("paid_at"));
		    if (paidTimeStamp != null) {
			shipment.setPaidAt(paidTimeStamp.toInstant().atOffset(ZoneOffset.UTC));
		    } else {
			shipment.setPaidAt(null);
		    }
		    shipments.add(shipment);
		}
	    }
	    return shipments;
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Shipment getOne(long id) throws SQLException {
	String sql = "SELECT * FROM shipment WHERE id = ( ? )";

	Shipment shipment = new Shipment();

	try (Connection conn = dataSource.getConnection()) {
	    PreparedStatement prepare = conn.prepareStatement(sql);
	    prepare.setLong(1, id);

	    try (ResultSet result = prepare.executeQuery()) {
		if (result.next()) {
		    shipment.setId(result.getLong("id"));
		    shipment.setStatus(Status.valueOf(result.getString("status")));
		    shipment.setAmount(result.getLong("amount"));
		    Timestamp paidTimeStamp = (result.getTimestamp("paid_at"));
		    if (paidTimeStamp != null) {
			shipment.setPaidAt(paidTimeStamp.toInstant().atOffset(ZoneOffset.UTC));
		    } else {
			shipment.setPaidAt(null);
		    }
		    return shipment;
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
    public Shipment create(Shipment t) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Shipment update(Shipment t) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(long id) throws SQLException {
	// TODO Auto-generated method stub

    }

}
