package com.example.demo.model;

import java.math.BigDecimal;

public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private boolean is_delete;

    public Product() {
    }

    public Product(long id, String name, BigDecimal price, boolean is_delete) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.is_delete = is_delete;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
    
}
