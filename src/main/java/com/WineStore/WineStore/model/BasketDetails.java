package com.WineStore.WineStore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "basket_details", schema = "wine_store")
public class BasketDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket1;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;
}
