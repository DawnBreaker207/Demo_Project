package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.order.OrderQueryRequestDTO;
import com.example.demo.dto.order.OrderRequestDTO;
import com.example.demo.dto.order.OrderResponseDTO;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {

	this.orderService = orderService;
    }

    @GetMapping("")
    public List<OrderResponseDTO> getQueryOrder(  OrderQueryRequestDTO param) throws SQLException {
	return orderService.filterOrder(param);

    }

    @GetMapping("/{id}")
    public Orders getOne(@PathVariable Long id) throws SQLException {
	return orderService.getOne(id);
    }

    @PostMapping("")
    public OrderResponseDTO create(@RequestBody OrderRequestDTO o) throws SQLException {
	return orderService.create(o);
    }

    @PutMapping("/{id}")
    public Orders update(@PathVariable Long id, @RequestBody OrderRequestDTO o) throws SQLException {
	return orderService.update(id, o);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws SQLException {
	orderService.delete(id);
    }
}