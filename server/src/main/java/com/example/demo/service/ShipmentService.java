package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
	this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> getAll() throws SQLException {
	return shipmentRepository.getAll();
    }
    
    public Shipment getOne(Long id ) throws SQLException {
	return shipmentRepository.getOne(id);
    }
    
    
}
