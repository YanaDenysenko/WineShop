package com.WineStore.WineStore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "wine", schema = "wine_store")
public class Wine{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "sweetness", nullable = false)
    private String sweetness;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "grape_sort", nullable = false)
    private String grape_sort;

    @Column(name = "classification", nullable = false)
    private String classification;

    @Column(name = "capacity", nullable = false)
    private double capacity;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
}
