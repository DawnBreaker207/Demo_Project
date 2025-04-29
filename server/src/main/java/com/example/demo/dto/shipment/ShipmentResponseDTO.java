package com.example.demo.dto.shipment;

import java.time.OffsetDateTime;

import com.example.demo.config.Status;
import com.example.demo.model.Orders;

public class ShipmentResponseDTO {

    private long id;
    private Status method;
    private long amount;
    private OffsetDateTime paidAt;

    public ShipmentResponseDTO() {

    }

    public ShipmentResponseDTO(long id, Status method, long amount, OffsetDateTime paidAt) {

	this.id = id;

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
