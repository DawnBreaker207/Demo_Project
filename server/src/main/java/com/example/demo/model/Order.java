package com.example.demo.model;

import java.time.OffsetDateTime;

import com.example.demo.config.Status;

public class Order {

    private long id;
    private Customer customerId;
    private int total;
    private Status status;
    private Status paymentStatus;
    private OffsetDateTime createdAt;

    public Order() {

    }

    public Order(long id, Customer customerId, int total, Status status, Status paymentStatus,
	    OffsetDateTime createdAt) {
	this.id = id;
	this.customerId = customerId;
	this.total = total;
	this.status = status;
	this.paymentStatus = paymentStatus;
	this.createdAt = createdAt;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Customer getCustomerId() {
	return customerId;
    }

    public void setCustomerId(Customer customerId) {
	this.customerId = customerId;
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(int total) {
	this.total = total;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public Status getPaymentStatus() {
	return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
	this.paymentStatus = paymentStatus;
    }

    public OffsetDateTime getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
	this.createdAt = createdAt;
    }

}
