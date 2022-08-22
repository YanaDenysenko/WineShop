package com.WineStore.WineStore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product_category", schema = "wine_store")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<>();
}
