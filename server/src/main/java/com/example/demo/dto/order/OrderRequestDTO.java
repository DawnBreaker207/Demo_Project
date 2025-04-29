package com.example.demo.dto.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestDTO {
    private Long customerId;
    private String shipmentMethod;
    private BigDecimal total;
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderRequestDTO() {

    }

    public OrderRequestDTO(Long customerId, String shipmentMethod, BigDecimal total, List<OrderItemDTO> items) {
	this.customerId = customerId;
	this.shipmentMethod = shipmentMethod;
	this.total = total;
	this.items = items;
    }

    public Long getCustomerId() {
	return customerId;
    }

    public void setCustomerId(Long customerId) {
	this.customerId = customerId;
    }

    public String getShipmentMethod() {
	return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
	this.shipmentMethod = shipmentMethod;
    }

    public BigDecimal getTotal() {
	return total;
    }

    public void setTotal(BigDecimal total) {
	this.total = total;
    }

    public List<OrderItemDTO> getItems() {
	return items;
    }

    public void setItems(List<OrderItemDTO> items) {
	this.items = items;
    }

}

