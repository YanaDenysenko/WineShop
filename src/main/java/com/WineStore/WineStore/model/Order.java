package com.WineStore.WineStore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order", schema = "wine_store")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id", referencedColumnName = "id", nullable = false)
    private Basket basket2;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @Column(name = "shipped_date", nullable = false)
    private Timestamp shippedDate;

    @ManyToOne()
    @JoinColumn(name = "status_id", nullable = false)
    private OrderStatus status;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;
}
