package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "shipment_item")
public class ShipmentItem {
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

}
