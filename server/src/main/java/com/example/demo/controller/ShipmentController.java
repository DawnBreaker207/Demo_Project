package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shipment;
import com.example.demo.service.ShipmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
	this.shipmentService = shipmentService;
    }

    @GetMapping("")
    public List<Shipment> getAll() throws SQLException {
	return shipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Shipment getOne(@PathVariable Long id) throws SQLException {
	return shipmentService.getOne(id);
    }

}
