package com.example.demo.model;

import java.time.OffsetDateTime;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "inventory")
public class Inventory {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "name")
    private Employees userUpdate;
}
