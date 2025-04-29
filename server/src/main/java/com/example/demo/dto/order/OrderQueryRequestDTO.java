package com.example.demo.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.config.Status;

public class OrderQueryRequestDTO {
    private String customerName;
    private Status orderStatus;
    private Status shipmentStatus;
    private BigDecimal minTotal;
    private BigDecimal maxTotal;
    private LocalDateTime createFrom;
    private LocalDateTime createTo;

    public OrderQueryRequestDTO() {

    }

    public OrderQueryRequestDTO(String customerName, Status orderStatus, Status shipmentStatus, BigDecimal minTotal,
	    BigDecimal maxTotal, LocalDateTime createFrom, LocalDateTime createTo) {

	this.customerName = customerName;
	this.orderStatus = orderStatus;
	this.shipmentStatus = shipmentStatus;
	this.minTotal = minTotal;
	this.maxTotal = maxTotal;
	this.createFrom = createFrom;
	this.createTo = createTo;
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

    public Status getShipmentStatus() {
	return shipmentStatus;
    }

    public void setShipmentStatus(Status shipmentStatus) {
	this.shipmentStatus = shipmentStatus;
    }

    public BigDecimal getMinTotal() {
	return minTotal;
    }

    public void setMinTotal(BigDecimal minTotal) {
	this.minTotal = minTotal;
    }

    public BigDecimal getMaxTotal() {
	return maxTotal;
    }

    public void setMaxTotal(BigDecimal maxTotal) {
	this.maxTotal = maxTotal;
    }

    public LocalDateTime getCreateFrom() {
	return createFrom;
    }

    public void setCreateFrom(LocalDateTime createFrom) {
	this.createFrom = createFrom;
    }

    public LocalDateTime getCreateTo() {
	return createTo;
    }

    public void setCreateTo(LocalDateTime createTo) {
	this.createTo = createTo;
    }

}
