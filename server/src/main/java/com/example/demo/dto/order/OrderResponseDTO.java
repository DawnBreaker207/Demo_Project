package com.example.demo.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.config.Status;

public class OrderResponseDTO {
    private long orderId;
    private String customerName;
    private Status orderStatus;
    private Status shipmentStatus;
    private BigDecimal total;
    private LocalDateTime createAt;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(long orderId, String customerName, Status orderStatus, Status shipmentStatus,
	    BigDecimal total, LocalDateTime createAt) {

	this.orderId = orderId;
	this.customerName = customerName;
	this.orderStatus = orderStatus;
	this.shipmentStatus = shipmentStatus;
	this.total = total;
	this.createAt = createAt;
    }

    public long getOrderId() {
	return orderId;
    }

    public void setOrderId(long orderId) {
	this.orderId = orderId;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public Status getOrderStatus() {
	return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
	this.orderStatus = orderStatus;
    }

    public BigDecimal getTotal() {
	return total;
    }

    public void setTotal(BigDecimal total) {
	this.total = total;
    }

    public LocalDateTime getCreateAt() {
	return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
	this.createAt = createAt;
    }

    public Status getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(Status shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

}
