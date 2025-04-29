package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.order.OrderQueryRequestDTO;
import com.example.demo.dto.order.OrderRequestDTO;
import com.example.demo.dto.order.OrderResponseDTO;
import com.example.demo.model.Orders;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
	this.orderRepository = orderRepository;
    }

    public List<OrderResponseDTO> filterOrder(OrderQueryRequestDTO query) throws SQLException {
	return orderRepository.getAll(query);
    }

    public Orders getOne(Long id) throws SQLException {
	return orderRepository.getOne(id);
    }

    public OrderResponseDTO create(OrderRequestDTO o) throws SQLException {
	return orderRepository.create(o);
    }

    public Orders update(Long id, OrderRequestDTO orderDto) throws SQLException {
	return null;
    }

    public void delete(Long id) throws SQLException {
	return;
    }

}
