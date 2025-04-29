package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dto.order.OrderQueryRequestDTO;
import com.example.demo.dto.order.OrderRequestDTO;
import com.example.demo.dto.order.OrderResponseDTO;
import com.example.demo.model.Orders;

public interface OrderRepository extends DAO<Orders> {
    List<OrderResponseDTO> getAll(OrderQueryRequestDTO query) throws SQLException;

    OrderResponseDTO create(OrderRequestDTO o) throws SQLException;
    
 }
