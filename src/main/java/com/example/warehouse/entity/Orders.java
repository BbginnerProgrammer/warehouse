package com.example.warehouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "provider")
    private String provider;

    private String quantity;

    @Column(name = "date")
    private java.sql.Date date;

    public Orders(String productName, String provider, String quantity, java.sql.Date date) {
        this.productName = productName;
        this.provider = provider;
        this.quantity = quantity;
        this.date = date;
    }
}
