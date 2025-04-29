package com.example.demo.model;

import java.time.OffsetDateTime;

import com.example.demo.config.Status;

public class Orders {

    private long id;
    private Customer customerId;
    private int total;
    private Status status;
    private Status paymentStatus;
    private OffsetDateTime createdAt;
    private Shipment shipmentId;
    private boolean is_delete ;


    public Orders() {

    }

    public Orders(long id, Customer customerId, int total, Status status, Status paymentStatus,
	    OffsetDateTime createdAt, Shipment shipmentId, boolean is_delete) {
	super();
	this.id = id;
	this.customerId = customerId;
	this.total = total;
	this.status = status;
	this.paymentStatus = paymentStatus;
	this.createdAt = createdAt;
	this.shipmentId = shipmentId;
	this.is_delete = is_delete;
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

    public Shipment getShipmentId() {
	return shipmentId;
    }

    public void setShipmentId(Shipment shipmentId) {
	this.shipmentId = shipmentId;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
    
    

}
