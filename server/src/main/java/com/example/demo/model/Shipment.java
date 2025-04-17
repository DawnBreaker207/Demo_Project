package com.example.demo.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "shipment")
public class Shipment {
    @Id
    private long id;

    private boolean status;

    @OneToMany
    @JoinColumn(name = "shipment_id")
    private List<ShipmentItem> shipmentItem;

}
