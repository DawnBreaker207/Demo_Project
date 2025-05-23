package com.example.demo.model;

import java.time.OffsetDateTime;

import com.example.demo.config.Status;

public class Shipment {

    private long id;
//    private Status method;
    private Status status;
    private long amount;
    private OffsetDateTime paidAt;

    public Shipment() {

    }

    public Shipment(long id, Status status, long amount, OffsetDateTime paidAt) {

	this.id = id;
	this.status = status;
	this.amount = amount;
	this.paidAt = paidAt;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
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
