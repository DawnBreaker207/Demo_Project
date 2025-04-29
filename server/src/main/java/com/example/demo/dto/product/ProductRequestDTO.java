package com.example.demo.dto.product;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ProductRequestDTO {
    private long id;
    private String name;
    private BigDecimal price;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(long id, String name, BigDecimal price) {
	this.id = id;
	this.name = name;
	this.price = price;
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
}
