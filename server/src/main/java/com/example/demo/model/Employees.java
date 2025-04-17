package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "employees")
public class Employees {
    @Id
    private long id;

    private String name;
}
