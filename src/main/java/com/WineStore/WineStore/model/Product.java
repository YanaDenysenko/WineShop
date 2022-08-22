package com.WineStore.WineStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product", schema = "wine_store")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "vendor_code", unique = true, nullable = false)
    private long vendorCode;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @OneToOne(mappedBy = "product")
    private Wine wine;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<BasketDetails> basketDetails = new ArrayList<>();
}
