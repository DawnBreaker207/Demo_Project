package com.example.demo.model;

import java.math.BigDecimal;

public class OrdertItem {

    private long id;
    private Order orderId;
    private Product productId;
    private int quantity;
    private BigDecimal price;

    public OrdertItem() {

    }

    public OrdertItem(long id, Order orderId, Product productId, int quantity, BigDecimal price) {
	this.id = id;
	this.orderId = orderId;
	this.productId = productId;
	this.quantity = quantity;
	this.price = price;
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

    public Product getProductId() {
	return productId;
    }

    public void setProductId(Product productId) {
	this.productId = productId;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

}
