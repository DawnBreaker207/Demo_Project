package com.example.demo.model;

import java.time.OffsetDateTime;

import com.example.demo.config.Status;

public class Shipment {

    private long id;
    private Order orderId;
    private Status method;
    private long amount;
    private OffsetDateTime paidAt;

    public Shipment() {

    }

    public Shipment(long id, Order orderId, Status method, long amount, OffsetDateTime paidAt) {

	this.id = id;
	this.orderId = orderId;
	this.method = method;
	this.amount = amount;
	this.paidAt = paidAt;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Order getOrderId() {
	return orderId;
    }

    public void setOrderId(Order orderId) {
	this.orderId = orderId;
    }

    public Status getMethod() {
	return method;
    }

    public void setMethod(Status method) {
	this.method = method;
    }

    public long getAmount() {
	return amount;
    }

    public void setAmount(long amount) {
	this.amount = amount;
    }

    public OffsetDateTime getPaidAt() {
	return paidAt;
    }

    public void setPaidAt(OffsetDateTime paidAt) {
	this.paidAt = paidAt;
    }

}
